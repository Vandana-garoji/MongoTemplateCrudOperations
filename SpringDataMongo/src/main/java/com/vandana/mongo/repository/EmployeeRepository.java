package com.vandana.mongo.repository;

import com.vandana.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Long> {

    Employee findByName(String name);
    @Query("{name: ?0}")
    Employee findByNameByQuery(String name);
    @Query("{name: {$eq : ? 0}}")
    Employee findByNameByQueryOperator(String name);

}
