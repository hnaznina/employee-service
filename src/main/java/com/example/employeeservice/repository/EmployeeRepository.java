package com.example.employeeservice.repository;

import java.util.List;

import com.example.employeeservice.vo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    List<Employee> findByLastName(String lastName);

}