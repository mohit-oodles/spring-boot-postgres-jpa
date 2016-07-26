package com.oodlestechnologies.blog.domains.ManyToOneU;

import com.oodlestechnologies.blog.domains.One2OneU.Employee;

import javax.persistence.*;


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


    @ManyToOne
    Employee employee;

    public Employee getEmployee() {
        return employee;
    }
}
