package com.example.employeeservice.service;

import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

//    @Transactional
//    @Override
//    public List<Employee> findByName(String name) {
//        return employeeRepository.findByLastName(name);
//    }

    @Transactional
    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeRepository.save(employee) != null;
    }

    @Transactional
    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.save(employee) != null;
    }

}
