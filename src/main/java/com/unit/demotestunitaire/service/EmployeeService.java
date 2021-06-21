package com.unit.demotestunitaire.service;

import com.unit.demotestunitaire.domain.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {


    Employee createOrUpadteEmployee(Employee employee);

    void deleteEmployee(UUID uuidEmployee);

    List<Employee> getAllEmployee();
}
