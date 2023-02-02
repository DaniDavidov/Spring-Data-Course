package com.example.spring_data_Intro.services;

import com.example.spring_data_Intro.models.User;
import com.example.spring_data_Intro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> exists = userRepository.getByUsername(user.getUsername());
        if (exists.isEmpty()) {
            userRepository.save(user);
        }
    }
}
