package com.vandana.mongo.service;

import com.vandana.mongo.dto.EmployeeDto;
import com.vandana.mongo.model.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(Long id);
    Employee getEmployeeListByName(String name);
    Employee updateEmployee(EmployeeDto employeeDto);
    void deleteEmployeeById(Long id);




}
