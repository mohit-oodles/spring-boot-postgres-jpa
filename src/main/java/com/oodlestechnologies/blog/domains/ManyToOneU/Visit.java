package com.oodlestechnologies.blog.domains.ManyToOneU;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long visitId;

    String purpose;
    String conclusion;

    public long getVisitId() {
        return visitId;
    }

    public void setVisitId(long visitId) {
        this.visitId = visitId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public float getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(float totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    float totalExpenses;
//
//
//    @OneToOne
//    @Cascade(CascadeType.DELETE)
//    Employee employee;
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
}

