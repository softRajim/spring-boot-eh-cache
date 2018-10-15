package com.rajim.ehcache.service;

import com.rajim.ehcache.doman.Employee;
import com.rajim.ehcache.dto.EmployeeDto;

import java.util.List;

/**
 * @author rajim on 10/14/18
 */

public interface EmployeeService {

    Employee addEmployeeInformation(EmployeeDto employeeDto);

    List<Employee> getAllEmployee();
}
