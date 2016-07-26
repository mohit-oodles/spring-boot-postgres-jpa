package com.oodlestechnologies.blog.repositories.visitManagement;

import com.oodlestechnologies.blog.domains.ManyToOneU.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 26/7/16.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

    ArrayList<Visit> findAll();

}
