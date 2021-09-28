package com.ashwani.redisspring.business.controller;

import com.ashwani.redisspring.infra.entity.User;
import com.ashwani.redisspring.infra.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/get/{userid}")
    @Cacheable(value = "users",key = "#userid")
    public User getUser(@PathVariable Long userid){
        LOG.info("Getting user with ID {}.", userid);
        return userService.find(userid);
    }

    @PostMapping("/save")
    @CachePut(value = "users", key = "#user.id")
    public User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @PutMapping("/update")
    @CachePut(value = "users", key = "#user.id")
    public User updatePersonByID(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable Long id) {
        LOG.info("deleting person with id {}", id);
        userService.delete(id);
    }
}
