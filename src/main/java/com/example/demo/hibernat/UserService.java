package com.example.demo.hibernat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(String userId){
        User user = userRepository.findByUserId(userId);
        return user;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
