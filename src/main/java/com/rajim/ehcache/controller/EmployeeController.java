package com.rajim.ehcache.controller;

import com.rajim.ehcache.doman.Employee;
import com.rajim.ehcache.dto.EmployeeDto;
import com.rajim.ehcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rajim on 10/14/18
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployeeInformation(employeeDto);
    }


}
