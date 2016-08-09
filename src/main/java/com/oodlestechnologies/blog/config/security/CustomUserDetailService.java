package com.oodlestechnologies.blog.config.security;

import com.oodlestechnologies.blog.domains.user.Role;
import com.oodlestechnologies.blog.domains.user.UserT;
import com.oodlestechnologies.blog.repositories.UserManagement.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oodles on 3/8/16.
 */
@Service
public class CustomUserDetailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

//    public CustomUserDetailService(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }


    public UserT loadUserByUsername(String username ,String password) throws UsernameNotFoundException {
        logger.info("UserDetailService started");
        try {
            UserT user = userRepository.findByUsername(username);
            if (user == null) {
                logger.debug("User not found");
                return null;
            }
            logger.debug(" user from username " + user.toString());
            return user;
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

}
