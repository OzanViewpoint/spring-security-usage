package com.ozan.springsecurityusage.auth.password;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("passwordUserDetailsService")
public class PasswordUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        UserDetails userDetails = User.withUsername("fox") .password("{noop}1234567").authorities("admin").build();
        return userDetails;
    }
}
