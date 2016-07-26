package com.oodlestechnologies.blog.controllers.projects;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import com.oodlestechnologies.blog.repositories.projectManagement.ProjectRepository;
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
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

   @RequestMapping(value = ("{id}"),method = RequestMethod.GET)
   Project getProject(@PathVariable long id){
       return projectRepository.findOne(id);
   }

    @RequestMapping(value = ("/"),method = RequestMethod.GET)
    ArrayList<Project> getAllProject(){
        return projectRepository.findAll();
    }


}
