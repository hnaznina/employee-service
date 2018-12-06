package com.example.employeeservice.controller;


import com.example.employeeservice.vo.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //@Controller @Service, @Component, @Bean, @Repository these are used to create Bean. There are different types of Beans.
@Log4j2
public class EmployeeController {

    //@RestController perform CRUD operation.
    //delete, get put(means Update), post(means Insert)
@GetMapping("/employees")
    public List<Employee> getAllEmployees(){
    log.info("Employee List: ");
        return new ArrayList<Employee>(){{
            add(new Employee(1, "Atik", "Chicago"));
        }};
    }

}
