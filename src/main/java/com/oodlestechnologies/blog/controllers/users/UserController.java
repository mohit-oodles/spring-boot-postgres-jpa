package com.oodlestechnologies.blog.controllers.users;
import com.oodlestechnologies.blog.domains.user.Person;
import com.oodlestechnologies.blog.repositories.userManagement.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    PersonRepository personRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public ArrayList<Person> getAllUsers(){
         ArrayList<Person> personList = new ArrayList<>();
        personList = personRepository.findAll();
        return personList;
    }

//    http://localhost:8080/users/12
    @RequestMapping(value = "/{id}/",method= RequestMethod.GET)
    public Person getUser(@PathVariable   int id){
        Person person = personRepository.findOne(Long.valueOf(id));
        return person;
    }

    @RequestMapping(value = "/",method= RequestMethod.POST)
    public Person addUsers(@RequestBody Person person){

        if (person!=null){
            personRepository.save(person);
        }

        return person;
    }

}
