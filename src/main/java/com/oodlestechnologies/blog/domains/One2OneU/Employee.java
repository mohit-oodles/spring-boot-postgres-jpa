package com.oodlestechnologies.blog.domains.One2OneU;

import javax.persistence.*;

/**
 * Created by oodles on 25/7/16.
 */

@Entity
public class Employee {

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

    @OneToOne
    BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
