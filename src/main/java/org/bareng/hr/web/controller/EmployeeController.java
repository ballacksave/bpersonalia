package org.bareng.hr.web.controller;

import org.bareng.hr.back.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String details(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeDetails(id));
		return "employees/details";
	}
}
