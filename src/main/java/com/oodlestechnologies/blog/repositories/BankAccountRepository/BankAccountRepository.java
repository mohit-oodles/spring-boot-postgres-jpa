package com.oodlestechnologies.blog.repositories.BankAccountRepository;

import com.oodlestechnologies.blog.domains.One2OneU.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by oodles on 27/7/16.
 */


public interface BankAccountRepository extends CrudRepository<BankAccount,Long>{
    ArrayList<BankAccount> findAll();


}
