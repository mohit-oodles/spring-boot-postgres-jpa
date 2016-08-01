package com.oodlestechnologies.blog.repositories.ExampleManagement;

import com.oodlestechnologies.blog.domains.example.C;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 29/7/16.
 */
public interface CRepository extends CrudRepository<C,Long> {

    ArrayList<C> findAll();
}
