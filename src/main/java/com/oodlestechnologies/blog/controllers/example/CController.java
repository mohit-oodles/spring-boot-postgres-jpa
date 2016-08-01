package com.oodlestechnologies.blog.controllers.example;
import com.oodlestechnologies.blog.domains.example.A;
import com.oodlestechnologies.blog.domains.example.B;
import com.oodlestechnologies.blog.domains.example.C;
import com.oodlestechnologies.blog.repositories.ExampleManagement.ARepository;
import com.oodlestechnologies.blog.repositories.ExampleManagement.BRespository;
import com.oodlestechnologies.blog.repositories.ExampleManagement.CRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("/C")

public class CController {

    @Autowired
    CRepository cRepository;

    @Autowired
    BRespository bRespository;

    @Autowired
    ARepository aRepository;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    C addC(@RequestBody C c) {

        Collection<B> bCollection = null;
        Collection<C> cCollection = null;

        //Create A
        A a = new A();
        a.setName("Sanjay mishra");
        a.setAddress("Ghaziabad");
        // Adding B's to A
        a.setBs(bCollection);

        // Create Many B
        B b = new B();
        b.setName("First");
        b.setOtherValue("Any Value");
        B b1 = new B();
        b1.setName("Second");
        b1.setOtherValue("Any Value");
        B b2 = new B();
        b2.setName("Third");
        b2.setOtherValue("Any Value");
        bCollection = new ArrayList<>();
        bCollection.add(b);
        bCollection.add(b1);
        bCollection.add(b2);
        // Adding C's to B
        b.setCs(cCollection);


        // Create Many C
        C c1 = new C();
        c1.setName("C First");
        c1.setAddress("Kanpur");
        c1.setAnotherProperty("Yes");
        C c2 = new C();
        c2.setName("C First");
        c2.setAddress("Kanpur");
        c2.setAnotherProperty("Yes");
        C c3 = new C();
        c3.setName("C First");
        c3.setAddress("Kanpur");
        c3.setAnotherProperty("Yes");
        cCollection = new ArrayList<>();
        cCollection.add(c);
        cCollection.add(c1);
        cCollection.add(c2);


        aRepository.save(a);

        return c;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ArrayList<C> getAllC(){
     return cRepository.findAll();

    }
}