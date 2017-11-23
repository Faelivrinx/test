package com.bookstore.repository;

import com.bookstore.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dominik on 29.04.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
