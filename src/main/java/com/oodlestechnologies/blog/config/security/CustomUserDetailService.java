package com.oodlestechnologies.blog.config.security;

import com.oodlestechnologies.blog.domains.user.Role;
import com.oodlestechnologies.blog.domains.user.UserT;
import com.oodlestechnologies.blog.repositories.UserManagement.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by oodles on 3/8/16.
 */
public class CustomUserDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserT user = userRepository.findByUsername(username);
            if (user == null) {
                logger.debug("user not found with the provided username");
                return null;
            }

            System.out.print(user);
            logger.debug(" user from username " + user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    getAuthorities(user));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(UserT user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        logger.debug("user authorities are " + authorities.toString());
        return authorities;
    }

}
