package com.example.employeeservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


}
