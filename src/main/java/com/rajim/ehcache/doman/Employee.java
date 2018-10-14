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
    @Column(nullable = false, unique = true)
    private long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;

    @OneToOne(mappedBy = "employee")
    private Address address;

}
