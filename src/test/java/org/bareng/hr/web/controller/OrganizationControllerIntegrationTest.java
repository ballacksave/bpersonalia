package org.bareng.hr.web.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.bareng.hr.back.entity.Organization;
import org.bareng.hr.back.repository.OrganizationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 
 * @author zakyalvan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
    @ContextConfiguration(locations="classpath*:spring/back/*-context.xml"),
    @ContextConfiguration(locations="classpath*:spring/web/*-context.xml")
})
@WebAppConfiguration
@Transactional(propagation=Propagation.REQUIRED)
public class OrganizationControllerIntegrationTest {
    @Autowired
    private WebApplicationContext applicationContext;
    
    @Autowired
    private OrganizationRepository organizationRepository;
    
    private MockMvc mockMvc;
    
    @Before
    public void prepare() {
        // Prepare mvc.
        mockMvc = webAppContextSetup(applicationContext).build();
        
        // Prepare database
        Organization first = new Organization();
        first.setName("First Organization");
        first.setRemarks("First Organization Remarks");
        
        
    }
    
    @Test
    public void testRegister_additionalRecordOnDatabase_thenRedirectToList() {
        
    }
    
    @Test
    public void testRegister_failOnInvalidRequiredFields_thenShowFormAgain() {
        
    }
    
    @Test
    public void testViewList_returnPagedListOfItem_showListPage() {
        
    }
    
    @Test
    public void testViewList_returnZeroPagedListOnInvalidPage_showListPage() {
        
    }
}
