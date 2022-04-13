package com.brijesh.cache.controller;

import com.brijesh.cache.entity.User;
import com.brijesh.cache.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID {}.", userId);
        int userIdL= Integer.valueOf(userId);
        Optional<User> user = userRepository.findById(userIdL);
        return user;
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/user")
    public User updatePersonByID(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/user/{id}")
    public void deleteUserByID(@PathVariable int id) {
        LOG.info("deleting person with id {}", id);
        userRepository.deleteById(id);
    }

    @GetMapping("/initialDataLoad")
    public void initialDataLoad(){
        //Populating embedded database here
        LOG.info("Saving users. Current user count is {}.", userRepository.count());
        User shubham = new User("Shubham", 2000);
        User pankaj = new User("Pankaj", 29000);
        User lewis = new User("Lewis", 550);

        userRepository.save(shubham);
        userRepository.save(pankaj);
        userRepository.save(lewis);
        LOG.info("Done saving users. Data: {}.", userRepository.findAll());
    }

}
