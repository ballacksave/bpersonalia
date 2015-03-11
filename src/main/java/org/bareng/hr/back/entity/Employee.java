package org.bareng.hr.back.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Employee implements Serializable {

    private Integer id;
    
    private String name;
    
    private Date dob;    // Date of Birth
    
    private GenderType gender;
    
    /* An attribute to save employee's agreements to the company.
    *  It forms a one to many relationship to the EmployeeAgreement class.
    */
    private List<EmployeeAgreement> agreements; 

    public Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<EmployeeAgreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<EmployeeAgreement> agreements) {
        this.agreements = agreements;
    }
}
