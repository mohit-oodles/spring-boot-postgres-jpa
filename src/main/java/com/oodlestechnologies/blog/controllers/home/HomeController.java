package com.oodlestechnologies.blog.controllers.home;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    // Index Page(default)
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    // User Page
    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public String getUser() {
        return "user/user";
    }

    // Admin Page
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public String getAdmin() {
        return "admin/admin";
    }
}