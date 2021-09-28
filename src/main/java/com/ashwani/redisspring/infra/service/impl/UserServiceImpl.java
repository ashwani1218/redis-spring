package com.ashwani.redisspring.infra.service.impl;

import com.ashwani.redisspring.infra.entity.User;
import com.ashwani.redisspring.infra.repository.UserRepository;
import com.ashwani.redisspring.infra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User find(Long id) {
         Optional<User> userOptional = userRepository.findById(id);
         if (userOptional.isPresent()){
             return userOptional.get();
         }
         else{
             return new User(-1L,"User Not Found",0L);
         }
    }

    @Override
//    @CachePut(value = "users", key = "#userid")
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
      userRepository.deleteById(id);
    }
}
