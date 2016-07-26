package com.oodlestechnologies.blog.controllers.auth;
import com.oodlestechnologies.blog.domains.user.Person;
import com.oodlestechnologies.blog.repositories.userManagement.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonRepository personRepyositor;

    @RequestMapping(value="/login" ,method=RequestMethod.POST)
    @ResponseBody
    Person checkLogin(@RequestBody Person person)
    {
        Person p = new Person();
        if (person!=null){
            person.setUsername("mohit");
            Date date =new Date();
            person.setLastLogin(String.valueOf(date.toString()));
            logger.info("result",p.getUsername());
        }
        else{
            person.setUsername("Invalid Person");
        }
        return p;
    }
}

