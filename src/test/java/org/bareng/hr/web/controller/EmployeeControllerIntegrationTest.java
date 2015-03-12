package org.bareng.hr.web.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bareng.hr.back.entity.Employee;
import org.bareng.hr.back.entity.GenderType;
import org.bareng.hr.back.repository.EmployeeRepository;
import org.bareng.hr.back.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Integration test sample for employee endpoints. Please note, all test method
 * requiring transaction because prepare method need to insert sample of data.
 * This test is disregard to security setings.
 * 
 * FIXME
 * 
 * Use dedicated database test tools or utilities, don't use our custom
 * components. False positive problem may arise for example by persistence
 * caching mechanism.
 * 
 * @author zakyalvan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
    @ContextConfiguration(locations = "classpath*:spring/back/*-context.xml"),
    @ContextConfiguration(locations = "classpath*:spring/web/*-context.xml") })
@WebAppConfiguration
public class EmployeeControllerIntegrationTest {
    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private EmployeeService employeeService;
    
    /**
     * Used for clarify database state. Next, we must use dedicated dbunit test
     * utilities.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> regiteredEmployees = new ArrayList<>();
    
    private MockMvc mockMvc;

    @Before
    public void prepare() {
        // Prepare mock mvc.
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext)
                .build();
        
        // Prepare data.
        Employee first = new Employee();
        first.setRegNumber("123");
        first.setFullName("Muhammad Zaky Alvan");
        first.setBirthDate(new Date());
        first.setEmailAddress("zakyalvan@bareng.org");
        first.setGender(GenderType.MALE);
        
        Employee second = new Employee();
        second.setRegNumber("123");
        second.setFullName("Zaky Alvan");
        second.setBirthDate(new Date());
        second.setEmailAddress("zaky@bareng.org");
        second.setGender(GenderType.MALE);
        
        employeeService.registerEmployee(first);
        employeeService.registerEmployee(second);
        
        regiteredEmployees.addAll(Arrays.asList(first, second));
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testRegisterEmployee_showCorrectFormOnGetRequest() throws Exception {
        mockMvc.perform(get("/employee/register"))
            .andExpect(status().isOk())
            .andExpect(view().name("employee/register"))
            .andExpect(forwardedUrl("/WEB-INF/views/employee/register.jsp"));
    }
    
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void testRegisterEmployee_oneRecordAddedToDatabase_showDetailsPage() throws Exception {
        mockMvc.perform(post("/employee/register")
                .param("regNumber", "123")
                .param("fullName", "Muhammad Zaky Alvan")
                .param("emailAddress", "zaky@bareng.or.id")
                .param("birthDate", "18/06/1945")
                .param("gender", "MALE"))
            .andExpect(status().is3xxRedirection());
        
        /**
         * Verify additional record exists on database.
         */
        Long recordCount = employeeRepository.countAll();
        assertThat(recordCount, is(new Long(3)));
    }
    
    /**
     * Testing validation mechanism, what happen if we do not give required
     * fullName and email address parameters for example.
     * 
     * @throws Exception
     */
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testRegisterEmployee_failOnEmptyRequiredFieldsAndShowForm() throws Exception {
        mockMvc.perform(post("/employee/register")
                .param("regNumber", "123")
                .param("birthDate", "18/06/1945")
                .param("gender", "MALE"))
            .andExpect(status().isOk())
            .andExpect(model().attributeHasFieldErrors("command", "fullName", "emailAddress"))
            .andExpect(view().name("employee/register"));
    }
    
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testShowEmployeeList_correntContentSizeOnValidPage_thenShowListPage() throws Exception {
        mockMvc.perform(get("/employee/list")
                .param("page", "0")
                .param("size", "10"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("pagedList"))
            .andExpect(model().attribute("pagedList", is(hasProperty("content", hasSize(2)))))
            .andExpect(view().name("employee/list"));
    }
    
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testShowEmployeeList_zeroContentOnInvalidPage_thenShowListPage() throws Exception {
        mockMvc.perform(get("/employee/list")
                .param("page", "1")
                .param("size", "10"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("pagedList"))
            .andExpect(model().attribute("pagedList", is(hasProperty("content", hasSize(0)))))
            .andExpect(view().name("employee/list"));
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testGetEmployeeDetails() throws Exception {
        Employee employee = regiteredEmployees.get(0);
        mockMvc.perform(get("/employee/detail/{id}", employee.getId()))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("employee"))
            .andExpect(model().attribute("employee", isA(Employee.class)))
            .andExpect(model().attribute("employee", is(hasProperty("id", equalTo(employee.getId())))))
            .andExpect(model().attribute("employee", is(hasProperty("fullName", equalTo(employee.getFullName())))))
            .andExpect(view().name("employee/detail"));
    }
    
    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void testGetEmployeeDetails_404HttpCodeOnNotFoundEmployeeById() throws Exception {
        mockMvc.perform(get("/employee/detail/{id}", 1))
            .andExpect(status().isNotFound());
    }
}
