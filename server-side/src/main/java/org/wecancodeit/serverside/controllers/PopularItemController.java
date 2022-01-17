package org.wecancodeit.serverside.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.serverside.models.PopularItem;
import org.wecancodeit.serverside.repositories.PopularItemRepository;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@CrossOrigin
public class PopularItemController {

    @Resource
    private PopularItemRepository popularItemRepo;

    @GetMapping("/api/popular-items")
    public Collection<PopularItem> getPopularItems() {
        return (Collection<PopularItem>) popularItemRepo.findAll();
    }

    @GetMapping("/api/popular-items/{popularItemId}")
    public PopularItem getPopularItem(@PathVariable Long popularItemId){
        return popularItemRepo.findById(popularItemId).get();
    }
}
