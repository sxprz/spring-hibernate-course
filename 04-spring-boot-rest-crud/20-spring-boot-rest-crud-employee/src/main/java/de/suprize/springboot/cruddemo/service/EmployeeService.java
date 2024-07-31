package de.suprize.springboot.cruddemo.service;

import de.suprize.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
