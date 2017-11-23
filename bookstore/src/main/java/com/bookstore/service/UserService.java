package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;

import java.util.Set;

/**
 * Created by Dominik on 24.04.2017.
 */
public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);
    User findById(Long id);

}
