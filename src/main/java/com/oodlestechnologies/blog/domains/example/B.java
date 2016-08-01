package com.oodlestechnologies.blog.domains.example;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    public B(){
    }

    public B(int ids){
        this.id = ids;
    }

    String name;
    String otherValue;

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

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
    }

    @ManyToOne
    A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }


    @OneToMany
    @Cascade(CascadeType.ALL)
    Collection<C> cs;

    public Collection<C> getCs() {
        return cs;
    }

    public void setCs(Collection<C> cs) {
        this.cs = cs;
    }


}
