package com.slippery.jsec.service;

import com.slippery.jsec.model.User;
import com.slippery.jsec.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repository;
    private final BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);

    AuthenticationManager authenticationManager;


    public UserServiceImpl(UserRepo repository, AuthenticationManager authenticationManager){
        this.repository=repository;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public User createNewUser(User userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return repository.save(userDetails);
    }

    @Override
    public String verify(User user) {
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return "success";
        }
        return "fail";
    }
}
