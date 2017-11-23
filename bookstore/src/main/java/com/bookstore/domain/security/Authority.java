package com.bookstore.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by Dominik on 23.04.2017.
 */
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 12345L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
