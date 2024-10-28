package com.slippery.jsec.service;

import com.slippery.jsec.model.User;
import com.slippery.jsec.model.UserPrincipal;
import com.slippery.jsec.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepo repository;
    public MyUserDetailsService(UserRepo repository){
        this.repository=repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repository.findByUsername(username);
        if(user ==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
