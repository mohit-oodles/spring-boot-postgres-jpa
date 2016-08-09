package com.oodlestechnologies.blog.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by oodles on 1/8/16.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
 /*   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceBean());
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Exclude API from Role based security.
        http.authorizeRequests()
                 .antMatchers("/api/v1/**").permitAll();
        // Check Roles
        http.authorizeRequests()
                .antMatchers("/user/**").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests()
                .anyRequest().authenticated();

        http
                // for Login
                .formLogin().failureUrl("/login")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .permitAll()
                .and()
                 // for logout
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .permitAll();

                 // Disable  CSRF (Cross Site Request Forgery) protection
                 http.csrf().disable();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider());
        // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        // ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        // auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
    @Bean
    CustomAuthenticationProvider authenticationProvider() {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        return provider;
    }

}
