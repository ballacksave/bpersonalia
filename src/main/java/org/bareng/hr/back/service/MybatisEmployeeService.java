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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated @Service
@Transactional(readOnly=true)
public class MybatisEmployeeService implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisEmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		return null;
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
	public Employee registerEmployee(Employee employee) {
		employeeRepository.save(employee);
		return null;
	}

	@Override
	public boolean isRegisteredEmployee(Integer id) {
		return employeeRepository.exists(id);
	}
}
