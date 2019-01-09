package com.example.employeeservice.controller;


import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.vo.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController //@Controller @Service, @Component, @Bean, @Repository these are used to create Bean. There are different types of Beans.
@Log4j2

//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Value("${message:nothing}")
    private String message;

    @PostConstruct
    public void intit(){
        Exception e = new Exception();
        log.info(">>>>"+message,e);
    }

    //@RestController perform CRUD operation.
    //delete, get put(means Update), post(means Insert)
    @GetMapping(value = "/employee", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        log.info("Message = " + message);
        log.info("Employee List: ");
        try {
            int c = 10 / 0;
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
    log.info("Employee id: " + id);
        return employeeService.getById(id);
    }

    @PostMapping(name = "/employee", produces = "application/json")
    public HttpStatus insertEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping(name="/employee", consumes = "application/json")
    public HttpStatus updateEmployee(@RequestBody Employee employee) {
        log.info("Update started");

        return employeeService.updateEmployee(employee) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

}
