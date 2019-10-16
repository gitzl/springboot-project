package com.neo.controller;

import com.company.User;
import com.company.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

@RestController
public class HelloController {

    @Autowired
   private CacheManager cacheManager;

    @Autowired
    private UserService userService;



    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 2.0!";
    }

    @RequestMapping(value = "api/cache/test1", method = RequestMethod.GET)
    public void setCache() {
        userService.getUser("king");
        System.out.println("set user cache success!");
    }

    @RequestMapping(value = "api/cache/test2", method = RequestMethod.GET)
    public void getCache() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        Iterator<String> iterator = cacheNames.iterator();
        if (iterator.hasNext()) {
            System.out.println("all cacheName is :" + iterator.next());
        }

        Cache userCache = cacheManager.getCache("userCache");
        if (userCache == null) {
            System.out.println("userCache is null ");
            return;
        }

        Object userObject =   userCache.get("king").get();
        if (userObject instanceof  User) {
            User user = (User) userObject;
            System.out.println("user cache info :" + "name is  :" + user.getName() + " age is : " + user.getAge());
        }

    }

}