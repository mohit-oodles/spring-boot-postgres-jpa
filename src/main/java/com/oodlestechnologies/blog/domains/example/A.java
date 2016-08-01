package com.oodlestechnologies.blog.domains.example;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by oodles on 29/7/16.
 */

@Entity
public class A {
//    public A(long id){
//
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    String address;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany
    @Cascade(CascadeType.ALL)
    Collection<B> bs;

    public Collection<B> getBs() {
        return bs;
    }

    public void setBs(Collection<B> bs) {
        this.bs = bs;
    }
}
