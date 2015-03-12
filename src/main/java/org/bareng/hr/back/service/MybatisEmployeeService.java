package org.bareng.hr.back.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.bareng.hr.back.entity.Employee;
import org.bareng.hr.back.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

@Validated @Transactional(readOnly = true) @Service
public class MybatisEmployeeService implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisEmployeeService.class);

    private EmployeeRepository employeeRepository;

    @Autowired
    public MybatisEmployeeService(EmployeeRepository employeeRepository) {
        Assert.notNull(employeeRepository, "Employee repository parameter must not be null");
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> getEmployees() {
        LOGGER.debug("Retrieve list of all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployees(Pageable pageable) {
        LOGGER.debug("Retrieve paged employees list with page {} and size", pageable.getPageNumber(), pageable.getPageSize());
        RowBounds rowBounds = new RowBounds(pageable.getOffset(), pageable.getPageSize());
        List<Employee> list = employeeRepository.findAll(rowBounds);
        Long totalRow = employeeRepository.countAll();
        Page<Employee> page = new PageImpl<>(list, pageable, totalRow);
        return page;
    }

    @Override
    public Employee getEmployeeDetails(Integer id) {
        LOGGER.debug("Retrieve employee details with id {}", id);
        return employeeRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Employee registerEmployee(Employee employee) {
        LOGGER.debug("Register an employee to employee database");
        employeeRepository.insert(employee);
        return employee;
    }

    @Override
    public boolean isRegisteredEmployee(Integer id) {
        return employeeRepository.exists(id);
    }
}
