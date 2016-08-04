package com.oodlestechnologies.blog.repositories.UserManagement;

import com.oodlestechnologies.blog.domains.user.UserT;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 2/8/16.
 */
public interface  UserRepository extends CrudRepository<UserT,Long> {

    ArrayList<UserT> findAll();

    UserT findByUsername(String username);
}
