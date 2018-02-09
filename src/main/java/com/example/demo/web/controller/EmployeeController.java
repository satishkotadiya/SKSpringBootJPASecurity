package com.example.demo.web.controller;

import com.example.demo.config.SecurityUtils;
import com.example.demo.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ksatish on 01-02-2018.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

/*    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;*/

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        if (SecurityUtils.isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/getAllEmployee";
        }
    }

    /*@GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }*/

    @GetMapping(value = {"/home"})
    public ModelAndView home() {
        return new ModelAndView("index", "employees", employeeService.getAll());
    }

    @GetMapping(value = "/getAllEmployee")
    public ModelAndView getAllEmployee() {
        return new ModelAndView("employeeList", "employees", employeeService.getAll());
    }
}
