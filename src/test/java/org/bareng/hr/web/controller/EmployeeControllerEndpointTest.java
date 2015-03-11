package org.bareng.hr.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.web.context.WebApplicationContext;

/**
 * Integration test sample for employee endpoint.
 * 
 * @author zakyalvan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(locations="classpath*:spring/back/*-context.xml"),
	@ContextConfiguration(locations="classpath*:spring/web/*-context.xml")
})
@WebAppConfiguration
public class EmployeeControllerEndpointTest {
	@Autowired
	private WebApplicationContext applicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void prepare() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext)
			.build();
	}
	
	@Test
	public void testGetEmployeeDetails() throws Exception {
		mockMvc.perform(get("/employees/{id}", 1))
			.andExpect(status().isOk());
	}
}
