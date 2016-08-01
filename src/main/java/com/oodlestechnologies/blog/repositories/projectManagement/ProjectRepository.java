package com.oodlestechnologies.blog.repositories.projectManagement;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 26/7/16.
 */
public interface ProjectRepository extends CrudRepository<Project,Long>{
    ArrayList<Project> findAll();

}
