package org.bareng.hr.web.controller;

import org.bareng.hr.back.entity.Employee;
import org.bareng.hr.back.service.EmployeeService;
import org.bareng.hr.web.commons.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value="/employees")
@SessionAttributes("command")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(Pageable page, Model model) {
		model.addAttribute("pagedList", employeeService.getEmployees(page));
		return "employees/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm(Model model) {
		LOGGER.debug("Showing registration form");
		model.addAttribute("command", new Employee());
		return "employees/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Validated @ModelAttribute("command") Employee employee, BindingResult binding, SessionStatus session) {
		LOGGER.debug("Handle registration form submission");
		if(binding.hasErrors()) {
			LOGGER.error("Registration data submitted contains error, reject them");
			return "employees/register";
		}
		
		// Proses object employee, misalnya persist ke dalam database.
		
		session.setComplete();
		return "redirect:/employees/list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showDetails(@PathVariable Integer id, Model model) {
		if(!employeeService.isRegisteredEmployee(id)) {
			throw new ResourceNotFoundException();
		}
		
		model.addAttribute("employee", employeeService.getEmployeeDetails(id));
		return "employees/details";
	}
}
