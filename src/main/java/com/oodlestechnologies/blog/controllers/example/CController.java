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
import java.util.Timer;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("api/v1/C")

public class CController {

    @Autowired
    CRepository cRepository;

    @Autowired
    BRespository bRespository;

    @Autowired
    ARepository aRepository;

    ArrayList<C> clist;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    C addC(@RequestBody C c) {

        Collection<B> bCollection = null;
        Collection<C> cCollection = null;

        // Create Many C
        // C1
        C c1 = new C();
        c1.setName("C First");
        c1.setAddress("Kanpur");
        c1.setAnotherProperty("Yes");
        // C2
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


        // Create Many B
        B b = new B();
        b.setName("First");
        b.setOtherValue("Any Value");
        // B1
        B b1 = new B();
        b1.setName("Second");
        b1.setOtherValue("Any Value");
        // B2
        B b2 = new B();
        b2.setName("Third");
        b2.setOtherValue("Any Value");
        bCollection = new ArrayList<>();
        bCollection.add(b);
        bCollection.add(b1);
        bCollection.add(b2);
        // Adding C's to B
        b.setCs(cCollection);



        //Create A
        A a = new A();
        a.setName("Sanjay mishra");
        a.setAddress("Ghaziabad");
        // Adding B's to A
        a.setBs(bCollection);


        aRepository.save(a);
        return c;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ArrayList<C> getAllC(){


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                C c=  new C();
                c.setName("runnable");
                cRepository.save(c);
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            cRepository.delete(Long.valueOf(106));
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                clist = cRepository.findAll();
            }
        });


        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        clist = cRepository.findAll();
                    }
                },
                1000
        );

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        cRepository.delete(Long.valueOf(106));
                    }
                },
                1000
        );

//
//        thread.start();
//        thread1.start();
//        thread2.start();

        return clist;
    }

}
