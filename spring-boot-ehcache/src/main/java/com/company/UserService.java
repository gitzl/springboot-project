package com.company;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "userCache", key = "#name")
    public User getUser(String name) {
        User user = new User();
        user.setAge(10);
        user.setName(name);
        return user;
    }
}
