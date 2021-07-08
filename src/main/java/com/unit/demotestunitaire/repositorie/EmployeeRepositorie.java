package com.unit.demotestunitaire.repositorie;

import com.unit.demotestunitaire.domain.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepositorie extends JpaRepository<Employee, UUID> {


    List<Employee> findAll();

    Employee getEmployeeByNomEmployeeAndPrenomEmployee(String nomEmployee, String prenomEmployee);

}
