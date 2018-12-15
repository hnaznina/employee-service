package com.example.employeeservice.controller;


import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.vo.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //@Controller @Service, @Component, @Bean, @Repository these are used to create Bean. There are different types of Beans.
@Log4j2

//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //@RestController perform CRUD operation.
    //delete, get put(means Update), post(means Insert)
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
    log.info("Employee List: ");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
    log.info("Employee id: " + id);
        return employeeService.getById(id);
    }

    @PostMapping("/employee")
    public HttpStatus insertEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/employee")
    public HttpStatus updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

}
