package com.oodlestechnologies.blog.domains.ManyToOneB;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;

import javax.persistence.*;

/**
 * Created by oodles on 26/7/16.
 */


@Entity
public class Project {

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
}
