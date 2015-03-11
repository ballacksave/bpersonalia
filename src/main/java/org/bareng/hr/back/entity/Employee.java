package org.bareng.hr.back.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

@SuppressWarnings("serial")
public class Employee implements Serializable {

    @NotNull
    private Integer id;

    @NotBlank
    private String regNumber;

    @NotBlank
    private String fullName;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    @NotBlank
    @Email
    private String emailAddress;

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

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
