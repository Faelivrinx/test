package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Dominik on 24.04.2017.
 */
@Service
public class UserServiceImpl  implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepositiory;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepositiory.findByUsername(user.getUsername());

        if(localUser != null){
            LOG.info(("User with username {} already exist. Nothing will be done"), user.getUsername());
        } else {
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            localUser = userRepositiory.save(user);
        }
        return localUser;
    }

    @Override
    public User findByUsername(String username) {
        return userRepositiory.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepositiory.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepositiory.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepositiory.findOne(id);
    }

}
