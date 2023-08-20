package com.example.waupetshop.service.impl;

import com.example.waupetshop.entity.Role;
import com.example.waupetshop.entity.User;
import com.example.waupetshop.repository.UserReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userReponsitory.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User " + email + "was not found in database!");
        }

        Set<Role> roles = user.getRoles();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role: roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            grantedAuthorities.add(authority);
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                        user.getName(),
                        user.getPassword(),
                        grantedAuthorities);

        return userDetails;
    }
}
