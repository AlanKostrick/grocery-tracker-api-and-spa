package org.wecancodeit.serverside.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.serverside.models.Item;
import org.wecancodeit.serverside.models.User;
import org.wecancodeit.serverside.repositories.ItemRepository;
import org.wecancodeit.serverside.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class ItemController {

    @Resource
    private ItemRepository itemRepo;

    @Resource
    private UserRepository userRepo;

    @GetMapping("/api/{userName}/items")
    public Collection<Item> getItems(@PathVariable String userName) {
        Optional<User> user = userRepo.findByUserName(userName);
        return user.get().getItems();
    }

    @PostMapping("/api/{userName}/items/add-item")
    public Collection<Item> addItem(@PathVariable String userName, @RequestBody String body) throws JSONException {
        JSONObject newItem = new JSONObject(body);
        String itemName = newItem.getString("name");
        boolean itemIsSelected = newItem.getBoolean("isSelected");
        Optional<Item> itemToAddOpt = itemRepo.findByName(itemName);
        //add item if not already in the database
        Optional<User> user = userRepo.findByUserName(userName);
        if (itemToAddOpt.isEmpty()) {
            Item itemToAdd = new Item(itemName, itemIsSelected);
            itemRepo.save(itemToAdd);
            user.get().addItem(itemToAdd);
            userRepo.save(user.get());
        }
        return user.get().getItems();
    }

    @PutMapping ("/api/items/{id}/select-item")
    public Collection<Item> selectItem(@PathVariable Long id, @RequestBody String body) throws JSONException {
        JSONObject newItem = new JSONObject(body);
        boolean itemIsSelected = newItem.getBoolean("isSelected");
        Optional<Item> itemToSelectOpt = itemRepo.findById(id);

        if (itemToSelectOpt.isPresent()) {
            itemToSelectOpt.get().setSelected(itemIsSelected);
            itemRepo.save(itemToSelectOpt.get());
        }
        return (Collection<Item>) itemRepo.findAll();
    }

    @DeleteMapping("/api/items/{id}/delete-item")
    public Collection<Item> deleteItem(@PathVariable Long id) throws JSONException {
        Optional<Item> itemToRemoveOpt = itemRepo.findById(id);
        if(itemToRemoveOpt.isPresent()){
            itemRepo.delete(itemToRemoveOpt.get());
        }
        return (Collection<Item>) itemRepo.findAll();
    }

}