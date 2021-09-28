package com.ashwani.redisspring.util.bootstrap;

import com.ashwani.redisspring.infra.entity.User;
import com.ashwani.redisspring.infra.repository.UserRepository;
import com.ashwani.redisspring.infra.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationRunner implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(1L,"Ashwani",1200L);
        User user2 = new User(2L,"Jane",1300L);
        User user3 = new User(3L,"Addy",1400L);
        User user4 = new User(4L,"JOhn",1500L);
        List<User> users = new ArrayList<>();
        LOG.info("Saving users [{}]",users);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        LOG.info("Saved Users count:[{}]",userRepository.count());
    }
}
