package com.oodlestechnologies.blog.controllers.user;
import com.oodlestechnologies.blog.domains.user.UserT;
import com.oodlestechnologies.blog.repositories.UserManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 2/8/16.
 */

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // SAVE
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    UserT addUser(@RequestBody UserT userT){
        userRepository.save(userT);
        return userT;
    }

    // FINDALL
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    ArrayList<UserT> getAllUsers(){
        return  userRepository.findAll();
    }

    // FIND
    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    UserT getUser(@RequestParam Long id){
        return  userRepository.findOne(id);
    }

    // DELETE
    @RequestMapping(value = "{id}" ,method = RequestMethod.DELETE)
    void removeUser(@RequestParam Long id){
        userRepository.delete(id);
    }



}
