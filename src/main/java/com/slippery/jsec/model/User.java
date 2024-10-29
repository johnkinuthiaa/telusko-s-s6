package com.slippery.jsec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean isEnabled;
    
}