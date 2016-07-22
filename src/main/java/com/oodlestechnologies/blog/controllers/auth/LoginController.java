package com.oodlestechnologies.blog.controllers.auth;
import com.oodlestechnologies.blog.domains.user.Person;
import com.oodlestechnologies.blog.repositories.userManagement.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
/**
 * Created by oodles on 19/7/16.
 */

@RestController
public class LoginController {
    @Autowired
    AuthenticationRepository authenticationRepository;

    @RequestMapping(value="/login" ,method=RequestMethod.POST)
    @ResponseBody
    Person checkLogin(@RequestBody Person person)
    {
        if (person !=null){
            System.out.print("--------Person is not Null-----------");
        }
        else{
            System.out.print("---------USER ELSE---------");
        }

        String a = person.getUsername();
        String b = person.getPassword();

        if (person!=null){
            person.setUsername("mohit");
            Date date =new Date();
            person.setLastLogin(String.valueOf(date.toString()));
            authenticationRepository.save(person);

        }
        else{
            person.setUsername("Invalid Person");
        }


        return person;
    }
}

