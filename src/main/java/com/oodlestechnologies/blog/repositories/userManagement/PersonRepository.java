package com.oodlestechnologies.blog.repositories.userManagement;

import com.oodlestechnologies.blog.domains.user.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PersonRepository extends CrudRepository<Person,Long> {

    ArrayList<Person> findAll();
}



