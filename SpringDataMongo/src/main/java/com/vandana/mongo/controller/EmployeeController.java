package com.vandana.mongo.controller;

import com.vandana.mongo.dto.EmployeeDto;
import com.vandana.mongo.model.Employee;
import com.vandana.mongo.service.EmployeeMongoTemplateService;
import com.vandana.mongo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")

public class EmployeeController {

    private EmployeeMongoTemplateService employeeService;
    @Autowired
    public  EmployeeController(EmployeeMongoTemplateService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        Employee employee=employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("get")
    public ResponseEntity<Employee> findEmployeeById(@RequestParam("id") Long id)
    {
        Employee employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("getAll")
    public ResponseEntity<Employee> findEmployeeByName(@RequestParam("name") String name)
    {
       Employee employees =employeeService.getEmployeeListByName(name);
        return ResponseEntity.ok(employees);
    }
    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto)
    {
        Employee employee=employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") Long id)
    {
       employeeService.deleteEmployeeById(id);
       return ResponseEntity.ok("Employee Successfully deleted");
    }


}
