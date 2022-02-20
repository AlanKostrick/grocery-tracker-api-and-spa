package org.wecancodeit.serverside;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.serverside.models.Item;
import org.wecancodeit.serverside.models.PopularItem;
import org.wecancodeit.serverside.models.User;
import org.wecancodeit.serverside.repositories.ItemRepository;
import org.wecancodeit.serverside.repositories.PopularItemRepository;
import org.wecancodeit.serverside.repositories.UserRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private PopularItemRepository popularItemRepo;

    @Resource
    private ItemRepository itemRepo;

    @Resource
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {

        PopularItem milk = new PopularItem("Milk", "$3");
        popularItemRepo.save(milk);
        PopularItem eggs = new PopularItem("Eggs", "$2");
        popularItemRepo.save(eggs);
        PopularItem sugar = new PopularItem("Sugar", "$1.50");
        popularItemRepo.save(sugar);

        Item bread = new Item("Bread", false);
        itemRepo.save(bread);

        Item water = new Item("Water", false);
        itemRepo.save(water);

        User user1 = new User("user1", bread);
        userRepo.save(user1);

        User user2 = new User("user2", water);
        userRepo.save(user2);
    }
}
