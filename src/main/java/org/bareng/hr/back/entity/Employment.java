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

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * A Class that hold employee's employment to a company's organization regarding to an agreement. 
 *
 * @author Arief Prihasanto <ariefp5758 at gmail.com>
 */
public class Employment {
    
    @NotNull
    private EmployeeAgreement agreement;
    
    @NotNull
    private Organization organization;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fromDate;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date thruDate;

    public EmployeeAgreement getAgreement() {
        return agreement;
    }

    public void setAgreement(EmployeeAgreement agreement) {
        this.agreement = agreement;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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
    
}
