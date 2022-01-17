package org.wecancodeit.serverside;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.serverside.models.Item;
import org.wecancodeit.serverside.models.PopularItem;
import org.wecancodeit.serverside.repositories.ItemRepository;
import org.wecancodeit.serverside.repositories.PopularItemRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private PopularItemRepository popularItemRepo;

    @Resource
    private ItemRepository itemRepo;

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
    }
}
