package com.oodlestechnologies.blog.controllers.employee;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import com.oodlestechnologies.blog.services.employee.EmployeeService;
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
    private EmployeeService employeeService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
        Employee addEmployee(@RequestBody Employee employee){
         return  employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
        ArrayList<Employee> getAllEmployee(){
        return  employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
        void deleteEmployee(@PathVariable int id){
            employeeService.removeEmployee(id);
        }

}


