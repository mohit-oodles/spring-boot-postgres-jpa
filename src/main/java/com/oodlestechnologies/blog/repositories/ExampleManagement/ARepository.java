package com.oodlestechnologies.blog.repositories.ExampleManagement;

import com.oodlestechnologies.blog.domains.example.A;
import com.oodlestechnologies.blog.domains.example.C;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by oodles on 31/7/16.
 */
public interface ARepository extends CrudRepository<A,Long> {

}
