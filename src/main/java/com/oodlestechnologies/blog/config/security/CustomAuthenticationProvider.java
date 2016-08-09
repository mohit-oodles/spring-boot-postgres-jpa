package com.oodlestechnologies.blog.config.security;

import com.oodlestechnologies.blog.domains.user.Role;
import com.oodlestechnologies.blog.domains.user.UserT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oodles on 8/8/16.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    CustomUserDetailService customUserDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        logger.debug("hi");
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        UserT user = customUserDetailService.loadUserByUsername(username, password);

        System.out.println("authenticated user information"+user);
        if (user != null) {
            System.out.println(user.getUsername());


            for(Role role:user.getRoles()) {
                grantedAuths.add(new SimpleGrantedAuthority(role.getRole()));
                logger.info("roles are: "+role.getRole());
            }
            return new UsernamePasswordAuthenticationToken(username, password,
                    grantedAuths);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}