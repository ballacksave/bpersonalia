package org.bareng.hr.back.repository;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Date;

import org.bareng.hr.back.entity.Employee;
import org.bareng.hr.back.entity.GenderType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit test to make sure our employee {@link Repository} mapping has written
 * correctly.
 * 
 * @author zakyalvan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/back/core-context.xml", "classpath*:spring/back/data-context.xml" })
public class EmployeeRepositoryTest {
    /**
     * Autowire component under test.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void testInsertOneNewEmployee() {
        Employee employee = new Employee();
        employee.setRegNumber("123");
        employee.setFullName("Muhammad Zaky Alvan");
        employee.setBirthDate(new Date());
        employee.setEmailAddress("zakyalvan@bareng.org");
        employee.setGender(GenderType.MALE);

        employeeRepository.insert(employee);
        
        /**
         * FIXME
         * 
         * Use dedicated db unit test tools or libraries, don't use our custom component for assertion.
         */
        assertThat(employeeRepository.countAll(), is(equalTo(1l)));
        assertThat(employee.getId(), allOf(is(notNullValue()), isA(Integer.class)));
    }
    
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testInsertListOfNewEmployee() {
        Employee firstEmployee = new Employee();
        firstEmployee.setRegNumber("123");
        firstEmployee.setFullName("Muhammad Zaky Alvan");
        firstEmployee.setBirthDate(new Date());
        firstEmployee.setEmailAddress("zakyalvan@bareng.org");
        firstEmployee.setGender(GenderType.MALE);
        
        Employee secondEmployee = new Employee();
        secondEmployee.setRegNumber("123");
        secondEmployee.setFullName("Zaky Alvan");
        secondEmployee.setBirthDate(new Date());
        secondEmployee.setEmailAddress("zaky@bareng.org");
        secondEmployee.setGender(GenderType.MALE);
        
        employeeRepository.insertAll(Arrays.asList(firstEmployee, secondEmployee));
        
        /**
         * FIXME
         * 
         * Use dedicated db unit test tools or libraries, don't use our custom component.
         */
        assertThat(employeeRepository.countAll(), is(equalTo(2l)));
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void testUpdateOneExistingEmployee() {
        
    }
    
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testUpdateListOfExistingEmployee() {
        
    }
    
    @Test
    @Transactional(readOnly=true)
    public void testFindAllEmployeeList() {
        
    }
    
    @Test
    @Transactional(readOnly=true)
    public void testFindPagedEmployeeList() {
        
    }
    
    @Test
    @Transactional(readOnly=true)
    public void testFindOneEmployee() {
        
    }
}
