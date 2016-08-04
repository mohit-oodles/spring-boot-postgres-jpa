package com.oodlestechnologies.blog.config.security;

import com.oodlestechnologies.blog.repositories.UserManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by oodles on 1/8/16.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserRepository userRepository;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceBean());
    }

    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new CustomUserDetailService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      //      http.authorizeRequests().anyRequest().authenticated();
//            http
//                .formLogin().failureUrl("/login?error")
//                .defaultSuccessUrl("/")
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//                .permitAll();
//
//            // Disable  CSRF (Cross Site Request Forgery) protection
//            http.authorizeRequests().antMatchers(HttpMethod.POST).permitAll();
            http.csrf().disable();


    }
}
