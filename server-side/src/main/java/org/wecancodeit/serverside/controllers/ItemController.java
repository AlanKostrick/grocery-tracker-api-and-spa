package org.wecancodeit.serverside.controllers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.serverside.models.Item;
import org.wecancodeit.serverside.repositories.ItemRepository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class ItemController {

    @Resource
    private ItemRepository itemRepo;

    @GetMapping("/api/items")
    public Collection<Item> getItems() {
        return (Collection<Item>) itemRepo.findAll();
    }

    @PostMapping("/api/items/add-item")
    public Collection<Item> addItem(@RequestBody String body) throws JSONException {
        JSONObject newItem = new JSONObject(body);
        String itemName = newItem.getString("name");
        boolean itemIsSelected = newItem.getBoolean("isSelected");
        Optional<Item> itemToAddOpt = itemRepo.findByName(itemName);
        //add item if not already in the database
        if (itemToAddOpt.isEmpty()) {
            Item itemToAdd = new Item(itemName, itemIsSelected);
            itemRepo.save(itemToAdd);
        }
        return (Collection<Item>) itemRepo.findAll();
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