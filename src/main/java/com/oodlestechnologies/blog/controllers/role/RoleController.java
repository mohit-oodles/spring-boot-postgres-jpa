package com.oodlestechnologies.blog.controllers.role;

import com.oodlestechnologies.blog.domains.user.Role;
import com.oodlestechnologies.blog.repositories.RoleManagement.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 2/8/16.
 */

@RequestMapping("api/v1/role")
@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    // SAVE
    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    Role addRole(@RequestBody Role role){
        roleRepository.save(role);
        return role;
    }

    // FINDALL
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    ArrayList<Role> getAllRoles(){
        return  roleRepository.findAll();
    }

    // FIND
    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    Role getUser(@RequestParam Long id){
        return  roleRepository.findOne(id);
    }

    // DELETE
    @RequestMapping(value = "{id}" ,method = RequestMethod.DELETE)
    void removeUser(@RequestParam Long id){
        roleRepository.delete(id);
    }


}
