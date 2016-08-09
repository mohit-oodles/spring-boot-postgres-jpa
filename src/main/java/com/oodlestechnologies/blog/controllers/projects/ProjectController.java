package com.oodlestechnologies.blog.controllers.projects;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import com.oodlestechnologies.blog.repositories.projectManagement.ProjectRepository;
import com.oodlestechnologies.blog.services.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 26/7/16.
 */


@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = ("/"),method = RequestMethod.POST)
    Project addProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @RequestMapping(value = ("/"),method = RequestMethod.GET)
    ArrayList<Project> getAllProject(){
        return  projectService.getAllProjects();
    }

   @RequestMapping(value = ("{id}"),method = RequestMethod.GET)
   Project getProject(@PathVariable long id){
       return projectService.getProject(id);
   }

    @RequestMapping(value = ("/"),method = RequestMethod.PUT)
    Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @RequestMapping(value = ("{id}"),method = RequestMethod.DELETE)
    void removeProject(@PathVariable long id){
        projectService.removeProject(id);
    }

}
