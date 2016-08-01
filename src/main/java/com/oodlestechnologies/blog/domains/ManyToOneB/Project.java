package com.oodlestechnologies.blog.domains.ManyToOneB;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import com.oodlestechnologies.blog.repositories.employeeManagement.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Project {
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


    @ManyToOne
    Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
