package com.oodlestechnologies.blog.services.employee;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import com.oodlestechnologies.blog.repositories.employeeManagement.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by oodles on 5/8/16.
 */

@Service
public class EmployeeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeRepository employeeRepository;
            /* CRUD OPERATIONS*/

    public Employee createEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public ArrayList<Employee> getAllEmployees(){
        return  employeeRepository.findAll();
    }

    public Employee getEmployee(long empId){
        return employeeRepository.findOne(empId);
    }


    @Transactional
    public Employee updateEmployee(Employee employee){
        Employee empFromDB = employeeRepository.findOne(employee.getEmpID());
        //Update here
        empFromDB.setName(employee.getName());
        empFromDB.setCity(employee.getCity());
        empFromDB.setAge(employee.getAge());
        logger.info("information:"+String.valueOf(empFromDB.getVersion()));

        employeeRepository.save(empFromDB);
        return empFromDB;

    }

    public void removeEmployee(long empId){
        employeeRepository.delete(empId);
    }

            /* BUSINESS OPERATIONS*/

}














