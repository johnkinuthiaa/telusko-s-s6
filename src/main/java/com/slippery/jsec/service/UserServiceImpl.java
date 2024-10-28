package com.slippery.jsec.service;

import com.slippery.jsec.model.User;
import com.slippery.jsec.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo repository, PasswordEncoder passwordEncoder){
        this.repository=repository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User createNewUser(User userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return repository.save(userDetails);
    }
}
