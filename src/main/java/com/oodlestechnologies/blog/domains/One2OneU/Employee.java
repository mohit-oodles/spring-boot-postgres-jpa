package com.oodlestechnologies.blog.domains.One2OneU;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.oodlestechnologies.blog.domains.ManyToOneB.Project;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by oodles on 25/7/16.
 */


@Entity
public class Employee implements Serializable {

    public  Employee(){

    }

    public  Employee(long id){
        this.empID = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long empID;

    @Version
    private long version;
    private  String name;
    private  String city;
    private  int age;


//    @Version
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date version;


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


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

//    public Long getVersion() {
//        return version;
//    }
//
//    public void setVersion(Long version) {
//        this.version = version;
//    }

    @OneToOne(orphanRemoval=true)
    @Cascade(CascadeType.ALL)
    BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    Collection<Project> projects;

    public Collection<Project> getProjects() {
        return projects;
    }
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }


}