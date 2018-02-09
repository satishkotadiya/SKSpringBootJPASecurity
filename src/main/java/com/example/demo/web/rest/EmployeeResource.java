package com.example.demo.web.rest;

import com.example.demo.data.entity.Employee;
import com.example.demo.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ksatish on 31-01-2018.
 */
@RestController
@RequestMapping({"/api"})
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = {"/getAllEmployee"} )
    public List<Employee> getAllEmployee() {
        return employeeService.getAll();
    }

    @PostMapping(value = {"/saveEmployee"} )
    public void saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping(value = {"/deleteEmployee"} )
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.delete(id);
    }

}
