package com.practice.pizzeria.services;

import com.practice.pizzeria.persistance.entity.UserEntity;
import com.practice.pizzeria.persistance.entity.UserRoleEntity;
import com.practice.pizzeria.persistance.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRespository userRespository;

    @Autowired
    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserEntity getUser(String name) {
        return this.userRespository.findById(name).orElse(null);
    }

    public List<UserEntity> getAllUsers(){
        return this.userRespository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRespository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not foud."));

        String[] roles = userEntity.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .roles(roles)
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisable())
                .build();
    }
}
