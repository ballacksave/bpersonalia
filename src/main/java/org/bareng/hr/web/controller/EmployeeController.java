package org.bareng.hr.web.controller;

import org.bareng.hr.back.entity.Employee;
import org.bareng.hr.back.service.EmployeeService;
import org.bareng.hr.web.commons.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String showList(Pageable pageable, Model model) {
        Page<Employee> pagedList = employeeService.getEmployees(pageable);
        model.addAttribute("pagedList", pagedList);
        return "employee/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        LOGGER.debug("Showing registration form");
        model.addAttribute("command", new Employee());
        return "employee/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Validated @ModelAttribute("command") Employee employee, BindingResult binding, SessionStatus session) {
        LOGGER.debug("Handle form submission of employee registration");
        if (binding.hasErrors()) {
            LOGGER.error("Registration data submitted contains error, reject them");
            return "employee/register";
        }

        employeeService.registerEmployee(employee);
        session.setComplete();
        return "redirect:/employee/detail/" + employee.getId();
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String showDetails(@PathVariable Integer id, Model model) {
        if (!employeeService.isRegisteredEmployee(id)) {
            throw new ResourceNotFoundException();
        }

        Employee employee = employeeService.getEmployeeDetails(id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }
}
