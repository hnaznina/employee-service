package com.example.employeeservice.service;

import com.example.employeeservice.vo.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    @Transactional
    List<Employee> getAllEmployees();

    @Transactional
    Employee getById(Long id);

//    @Transactional
//    List<Employee> findByName(String name);

    @Transactional
    void deleteEmployee(Long employeeId);

    @Transactional
    boolean addEmployee(Employee employee);

    @Transactional
    boolean updateEmployee(Employee employee);
}
