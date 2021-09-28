package com.ashwani.redisspring.infra.service;

import com.ashwani.redisspring.infra.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User find(Long id);

    void save(User user);

    void delete(Long id);
}
