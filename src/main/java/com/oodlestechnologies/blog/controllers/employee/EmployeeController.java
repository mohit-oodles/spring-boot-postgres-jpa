package com.oodlestechnologies.blog.controllers.employee;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import com.oodlestechnologies.blog.repositories.employeeManagement.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by oodles on 25/7/16.
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository employeeRepository;



    @RequestMapping(value = "/",method = RequestMethod.POST)
    Employee addEmployee(@RequestBody Employee employee){
        Employee employee1 = null;
        if (employee!=null){
            employee1= employeeRepository.save(employee);

        }
        return  employee1;
    }



    @RequestMapping(value = "/",method = RequestMethod.GET)
    ArrayList<Employee> getEmployee(){
        ArrayList<Employee> emplist = employeeRepository.findAll();
        return  emplist;
    }


    //    http://localhost:8080/employee/15
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    Employee getEmployee(@PathVariable int id){
        Employee employee1 = null;
        if (id!=0){
            employee1= employeeRepository.findOne(Long.valueOf(id));
        }
        return  employee1;
    }



}


