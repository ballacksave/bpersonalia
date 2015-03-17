package org.bareng.hr.back.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/back/data-context.xml"})
@ActiveProfiles("test")
public class OrganizationRepositoryTest {
    /**
     * Component under test.
     */
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @Test
    public void testInsertOne_successAllRequiredFieldsGiven() {
        
    }
}
