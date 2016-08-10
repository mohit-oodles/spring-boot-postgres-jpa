package com.oodlestechnologies.blog.config.security;

import com.oodlestechnologies.blog.domains.user.UserT;
import com.oodlestechnologies.blog.repositories.UserManagement.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserT loadUserByUsername(String username ,String password) throws UsernameNotFoundException {
        logger.info("UserDetailService started");
        try {
            UserT user = userRepository.findByUsername(username);
            System.out.println(" user from username:  " + user.getPassword().toString());

            if (user != null) {
                boolean matched = passwordEncoder.matches(password, user.getPassword());
                logger.debug("User not found");
                if (matched){
                    return  user;
                }
                return null;
            }
            else{
                return  null;
            }
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

}
