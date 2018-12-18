package com.example.employeeservice.runner;

import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.vo.Employee;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
@Component
@Order(1)
@Log4j2
public class AnotherDatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data from Another Database Loader...");

        employeeService.addEmployee(new Employee(1L,30, "Naz", "Hoq"));
        employeeService.addEmployee(new Employee(2L,7, "Beh", "Ahmed"));
        employeeService.addEmployee(new Employee(3L,4, "Ihti", "Ahmed"));

 
    }
 
}