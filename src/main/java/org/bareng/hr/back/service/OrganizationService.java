package org.bareng.hr.back.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.bareng.hr.back.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Contract for service object for managing {@link Organization}.
 * 
 * @author zakyalvan
 */
public interface OrganizationService {
    /**
     * Retrieve list of all organizations.
     * 
     * @return
     */
    List<Organization> getOrganizations();

    /**
     * Retrieve paged list of organizations.
     * 
     * @return
     */
    Page<Organization> getOrganzations(@NotNull Pageable page);

    /**
     * Retrieve organization details based on given id.
     * 
     * @param id
     * @return
     */
    Organization getOrganization(@NotNull Integer id);

    /**
     * Register new {@link Organization}.
     * 
     * @param organization
     * @return
     */
    Organization register(@NotNull Organization organization);

    /**
     * Ask whether {@link Organization} with given id already exists.
     * 
     * @param organization
     * @return
     */
    boolean isRegistered(@NotNull Integer id);

    /**
     * Remove organization with given id.
     * 
     * @param id
     */
    void remove(@NotNull Integer id);
}
