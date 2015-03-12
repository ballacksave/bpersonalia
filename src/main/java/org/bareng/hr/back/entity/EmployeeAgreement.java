/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bareng.hr.back.entity;


import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

/**
 * A Class that holds agreement between employee and the company.
 *
 * @author Arief Prihasanto <ariefp5758 at gmail.com>
 */
public class EmployeeAgreement {
    
    @NotNull
    private Employee employee;
    
    @NotNull
    private EmployeeAgreementType agreementType;
    
    @NotNull
    private Date fromDate;
    
    private Date thruDate;
    
    /*
    * An attribute to save employment's history of an employee regarding to an agreement.
    */
    private List<Employment> employments;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeAgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(EmployeeAgreementType agreementType) {
        this.agreementType = agreementType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }
}
