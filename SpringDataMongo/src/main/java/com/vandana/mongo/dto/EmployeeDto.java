package com.vandana.mongo.dto;

public class EmployeeDto {
    private Long id;

    public int getId() {
        return Math.toIntExact(id);
    }

    private String name;

    private int age;

    private int salary;

    private String department;

}
