package com.vandana.mongo.service;

import com.vandana.mongo.dto.EmployeeDto;
import com.vandana.mongo.model.Employee;
import com.vandana.mongo.repository.EmployeeRepository;
import com.vandana.mongo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


 private EmployeeRepository employeeRepository;
 @Autowired
 public EmployeeServiceImpl(EmployeeRepository employeeRepository)
 {
     this.employeeRepository=employeeRepository;
 }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {

        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();

    }

    @Override
    public Employee getEmployeeListByName(String name) {
        return employeeRepository.findByNameByQuery(name);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee =getEmployeeById((long) employeeDto.getId());
        BeanUtils.copyProperties(employeeDto,employee);
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployeeById(Long id) {




    }
}
