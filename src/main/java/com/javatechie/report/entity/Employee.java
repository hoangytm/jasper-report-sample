package com.javatechie.report.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {
    @Id
    private int id;
    private String name;
    private String country;
    private double salary;
    private String doj;

    public Employee(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
