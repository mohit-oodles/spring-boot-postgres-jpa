package com.oodlestechnologies.blog.domains.One2OneU;

import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by oodles on 25/7/16.
 */

@Entity
public class Employee {

    public  Employee(long id){
        this.empID = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long empID;

    String name;
    String city;
    int age;


    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToOne(orphanRemoval=true)
    @Cascade(CascadeType.ALL)
    BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @OneToMany()
    @Cascade(CascadeType.ALL)

    Collection<Project> projects;
    public Collection<Project> getProjects() {
        return projects;
    }
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }


}