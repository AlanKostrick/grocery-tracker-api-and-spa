package org.wecancodeit.serverside.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.serverside.models.User;
import org.wecancodeit.serverside.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserRepository userRepo;

    @GetMapping("/api/users/{userName}")
    public Optional<User> getUser(@PathVariable String userName){

        return userRepo.findByUserName(userName);
    }
}
