package com.oodlestechnologies.blog.controllers.auth;
import com.oodlestechnologies.blog.config.security.AppSecurityConfig;
import com.oodlestechnologies.blog.domains.user.Person;
import com.oodlestechnologies.blog.repositories.userManagement.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RequestMapping(value="/login" ,method = RequestMethod.POST)
//    String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password)
//    {
//        String result = "invalid";
//        // Spring security UserT details service, UserAuthenticationProvider
//        System.out.print("----:\n"+"UserT: "+username+"\npass: "+password+"----");
//        if (username.equals("mohi")&& password.equals("pass")){
//            result="auth/success";
//        }
//        else{
//            result="auth/failure";
//        }
//        return result;
//    }

    // Take to the login vm
    @RequestMapping(value="/login" ,method = RequestMethod.GET)
    String login() {
        return "auth/login";
    }

}

