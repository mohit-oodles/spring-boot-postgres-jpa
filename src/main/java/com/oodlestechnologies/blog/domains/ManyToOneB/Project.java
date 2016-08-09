package com.oodlestechnologies.blog.domains.ManyToOneB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import com.oodlestechnologies.blog.repositories.employeeManagement.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Collection;


@Entity

public class Project implements Serializable {
        public Project(){
        }

        public Project(long id){
        this.projectId = id;
        }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long projectId;
    String projectName;
    String assignedTo;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    //    Collection<Employee> employees;
//
//    public Collection<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Collection<Employee> employees) {
//        this.employees = employees;
//    }
}
