package com.oodlestechnologies.blog.controllers.visit;

import com.oodlestechnologies.blog.domains.ManyToOneU.Visit;
import com.oodlestechnologies.blog.repositories.visitManagement.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by oodles on 26/7/16.
 */

@RestController
@RequestMapping("/visits")
public class VisitController  {

    @Autowired
    VisitRepository visitRepository;


    @RequestMapping( value = "{id}" ,method = RequestMethod.GET)
    Visit getVisit(@PathVariable long id){

        return visitRepository.findOne(id);

    }

    @RequestMapping( value = "/" ,method = RequestMethod.GET)
        ArrayList<Visit> getAllVisit(){

        return visitRepository.findAll();

    }
}
