package com.oodlestechnologies.blog.controllers.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oodles on 19/7/16.
 */
@Controller
public class SignUpController {

    @RequestMapping("/register")
    public String index(){
        return "UserT/signup";
    }
}
