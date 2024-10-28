package com.slippery.jsec.service;

import com.slippery.jsec.model.User;
import com.slippery.jsec.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repository;
    private final BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);


    public UserServiceImpl(UserRepo repository){
        this.repository=repository;
    }
    @Override
    public User createNewUser(User userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return repository.save(userDetails);
    }
}
