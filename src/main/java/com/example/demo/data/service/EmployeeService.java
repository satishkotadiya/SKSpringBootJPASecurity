package com.example.demo.data.service;

import com.example.demo.data.entity.Employee;
import com.example.demo.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ksatish on 31-01-2018.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void delete(List<Employee> employeeList) {
        employeeRepository.delete(employeeList);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
