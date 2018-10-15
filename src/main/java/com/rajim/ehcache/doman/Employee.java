package com.rajim.ehcache.doman;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author rajim on 10/14/18
 */

@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;

}
