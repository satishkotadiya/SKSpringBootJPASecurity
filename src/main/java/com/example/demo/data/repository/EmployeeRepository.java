package com.example.demo.data.repository;

import com.example.demo.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ksatish on 31-01-2018.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
