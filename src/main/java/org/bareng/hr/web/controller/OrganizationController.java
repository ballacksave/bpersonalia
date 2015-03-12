package org.bareng.hr.web.controller;

import org.bareng.hr.back.entity.Organization;
import org.bareng.hr.back.service.OrganizationService;
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
@RequestMapping(value = "/organization")
@SessionAttributes({ "command" })
public class OrganizationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Pageable page, Model model) {
        LOGGER.debug("Show list of organization for page {} and size {}", page.getPageNumber(), page.getPageSize());
        return "organization/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String registerForm(Model model) {
        LOGGER.debug("Show register organization form.");
        model.addAttribute("command", new Organization());
        return "organization/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processRegistation(@Validated @ModelAttribute("command") Organization organization, BindingResult binding, SessionStatus status) {
        if (binding.hasErrors()) {
            LOGGER.error("Register organization form contains error, reject them!");
            return "organization/add";
        }
        organizationService.register(organization);
        status.setComplete();
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Integer id, Model model) {
        LOGGER.debug("Show update organization form.");

        if (!organizationService.isRegistered(id)) {
            LOGGER.debug("Organization with id {} not found on database.");
            throw new ResourceNotFoundException();
        }

        Organization organization = organizationService.getOrganization(id);
        model.addAttribute("command", organization);
        return "organization/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String processUpdate(@PathVariable("id") Integer id, @Validated @ModelAttribute("command") Organization organization, BindingResult binding, SessionStatus status) {
        if (binding.hasErrors()) {
            LOGGER.error("Update organization form contains error, reject them!");
            return "organization/update";
        }

        status.setComplete();
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String remove(@PathVariable("id") Integer id) {
        if (!organizationService.isRegistered(id)) {
            throw new ResourceNotFoundException();
        }
        organizationService.remove(id);
        return "";
    }
}
