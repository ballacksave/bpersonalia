package org.bareng.hr.back.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.bareng.hr.back.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Contract.
 * 
 * @author zakyalvan
 */
public interface EmployeeService {
    List<Employee> getEmployees();

    /**
     * Retrieve paged list of employees.
     * 
     * @return
     */
    Page<Employee> getEmployees(@NotNull Pageable pageable);

    /**
     * Find employee details by id.
     * 
     * @param id
     * @return
     */
    Employee getEmployeeDetails(@NotNull Integer id);

    /**
     * Register an employee, return persisted version.
     * 
     * @param employee
     * @return
     */
    Employee registerEmployee(Employee employee);

    /**
     * Check whether given id is id of registered employee.
     * 
     * @param id
     * @return
     */
    boolean isRegisteredEmployee(@NotNull Integer id);
}
