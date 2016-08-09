package com.oodlestechnologies.blog.services.project;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import com.oodlestechnologies.blog.repositories.projectManagement.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectService {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(Project project){
        return  projectRepository.save(project);
    }

    public ArrayList<Project> getAllProjects(){
        return  projectRepository.findAll();
    }

    public Project getProject(long id) {
        return projectRepository.findOne(id);
    }

    public Project updateProject(Project project){
        Project temp;
        temp = projectRepository.findOne(project.getProjectId());
        project = temp;
        //Update here
        return projectRepository.save(project);
    }

    public void removeProject(long id){
        projectRepository.delete(id);
    }


}


