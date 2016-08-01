package com.oodlestechnologies.blog.controllers.projects;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import com.oodlestechnologies.blog.repositories.projectManagement.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 26/7/16.
 */


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    // GET
   @RequestMapping(value = ("{id}"),method = RequestMethod.GET)
   Project getProject(@PathVariable long id){
       return projectRepository.findOne(id);
   }

   // GET ALL
    @RequestMapping(value = ("/"),method = RequestMethod.GET)
    ArrayList<Project> getAllProject(){
        return projectRepository.findAll();
    }

    // PUT
    @RequestMapping(value = ("/"),method = RequestMethod.PUT)
    Project updateProject(@RequestBody Project project){
        Project tempProject= projectRepository.findOne(project.getProjectId());
        tempProject = project;
        return projectRepository.save(tempProject);
    }

    //POST
    @RequestMapping(value = ("/"),method = RequestMethod.POST)
    Project addProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    // Delete
    @RequestMapping(value = ("{id}"),method = RequestMethod.DELETE)
    void removeProject(@PathVariable long id){
         projectRepository.delete(id);
    }

}
