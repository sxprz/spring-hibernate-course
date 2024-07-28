package de.suprize.springboot.cruddemo.dao;

import de.suprize.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
