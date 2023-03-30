package com.digitalbooking.back.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomAuthentication implements Authentication {

    private UserDetails userDetails;
    private Collection<SecurityAuthority> authorities;
    private boolean authenticated;


    public CustomAuthentication(UserDetails userDetails, Collection<SecurityAuthority> authorities) {
        this.userDetails = userDetails;
        this.authorities = authorities;
        this.authenticated = true;
    }

    @Override
    public Collection<SecurityAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return userDetails.getPassword();
    }

    @Override
    public Object getDetails() {
        return userDetails;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userDetails.getUsername();
    }

}
