package com.rajim.ehcache.service;

import com.rajim.ehcache.doman.Employee;
import com.rajim.ehcache.dto.EmployeeDto; /**
 * @author rajim on 10/14/18
 */

public interface EmployeeService {

    Employee addEmployeeInformation(EmployeeDto employeeDto);
}
