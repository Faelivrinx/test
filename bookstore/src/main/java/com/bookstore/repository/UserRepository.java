package com.bookstore.repository;

import com.bookstore.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dominik on 24.04.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();


}
