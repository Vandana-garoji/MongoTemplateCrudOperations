package com.vandana.mongo.service;

import com.vandana.mongo.dto.EmployeeDto;
import com.vandana.mongo.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMongoTemplateService implements  EmployeeService{
    private final MongoTemplate mongoTemplate;

    @Autowired
    public EmployeeMongoTemplateService(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate=mongoTemplate;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return mongoTemplate.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id)
    {
//        Query query=new Query();
//        query.addCriteria(Criteria.where("id").is(id));
        Employee employee =mongoTemplate.findById(id,Employee.class);
        return employee;
    }

    @Override
    public Employee getEmployeeListByName(String name) {


        return mongoTemplate.findById(name,Employee.class);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = getEmployeeById((long) employeeDto.getId());
        BeanUtils.copyProperties(employeeDto,employee,"id");
        return mongoTemplate.save(employee);

    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = getEmployeeById(id);

         mongoTemplate.remove(employee);
    }
}
