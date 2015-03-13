/*
 *
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

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * A Class that hold organizational tree of the company.
 *
 * @author Arief Prihasanto <ariefp5758 at gmail.com>
 */
public class Organization implements Serializable {
    
    @NotNull
    private int id;
    
    @NotBlank
    private String name;
    
    private String remarks;
    
    private Organization parent;
    
    private List<Organization> child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
}
