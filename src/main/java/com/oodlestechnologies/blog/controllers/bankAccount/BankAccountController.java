package com.oodlestechnologies.blog.controllers.bankAccount;

import com.oodlestechnologies.blog.domains.One2OneU.BankAccount;
import com.oodlestechnologies.blog.repositories.BankAccountRepository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 27/7/16.
 */

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    BankAccount getBankAccount(@PathVariable long id){
        return bankAccountRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    void deleteBankAccount(@PathVariable long id){
        bankAccountRepository.delete(id);
    }

    @RequestMapping(value = ("/") , method = RequestMethod.GET)
    ArrayList<BankAccount> getAllBankAccount(){
        return bankAccountRepository.findAll();
    }

}
