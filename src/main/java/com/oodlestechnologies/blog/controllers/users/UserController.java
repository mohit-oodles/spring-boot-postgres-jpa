package com.oodlestechnologies.blog.controllers.users;
import com.oodlestechnologies.blog.domains.user.Person;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public ArrayList<Person> getAllUsers(){
         ArrayList<Person> personList = new ArrayList<>();
        return personList;
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.GET)
    public Person getUser(@PathVariable   int id){
        Person person =  new Person();
        return person;
    }

    @RequestMapping(value = "/",method= RequestMethod.POST)
    public Person getUsers(){
        Person person =  new Person();
        return person;
    }

}
