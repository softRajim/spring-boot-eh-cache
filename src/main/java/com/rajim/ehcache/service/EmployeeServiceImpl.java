package com.rajim.ehcache.service;

import com.rajim.ehcache.doman.Address;
import com.rajim.ehcache.doman.Employee;
import com.rajim.ehcache.dto.EmployeeDto;
import com.rajim.ehcache.repo.AddressRepository;
import com.rajim.ehcache.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rajim on 10/14/18
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AddressRepository addressRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    @Transactional
    public Employee addEmployeeInformation(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        Employee employee1 = employeeRepository.save(employee);
        Address address = new Address();
        address.setAddressLine1(employeeDto.getAddressLine1());
        address.setCity(employeeDto.getCity());
        address.setZipcode(employeeDto.getZipCode());
        address.setEmployee(employee1);
        addressRepository.save(address);
        return employee1;
    }

    @Override
    @Cacheable(value = "employee", key = "employeeList")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


}
