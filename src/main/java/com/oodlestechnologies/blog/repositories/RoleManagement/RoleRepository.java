package com.oodlestechnologies.blog.repositories.RoleManagement;

import com.oodlestechnologies.blog.domains.user.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 2/8/16.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
    ArrayList<Role> findAll();

}
