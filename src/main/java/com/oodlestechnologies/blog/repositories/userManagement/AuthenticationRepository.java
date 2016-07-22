package com.oodlestechnologies.blog.repositories.userManagement;

import com.oodlestechnologies.blog.domains.user.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by oodles on 22/7/16.
 */

public interface AuthenticationRepository extends CrudRepository<Person,Long> {


}
