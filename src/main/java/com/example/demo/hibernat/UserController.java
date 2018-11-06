package com.example.demo.hibernat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@RequestBody User user){
        System.out.println("user:" + user);
        return userService.saveUser(user);
    }
}
