package com.slippery.jsec.service;

import com.slippery.jsec.model.User;

public interface UserService {
    User createNewUser(User userDetails);
    String verify(User user);
}
