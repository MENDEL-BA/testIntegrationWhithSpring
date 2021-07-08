package com.unit.demotestunitaire.service.serviceImpl;

import com.unit.demotestunitaire.domain.Departement;
import com.unit.demotestunitaire.domain.Employee;
import com.unit.demotestunitaire.repositorie.DepartementRepositorie;
import com.unit.demotestunitaire.repositorie.EmployeeRepositorie;
import com.unit.demotestunitaire.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private DepartementRepositorie departementRepositorie;

    @Autowired
    private EmployeeRepositorie employeeRepositorie;

    @Override
    public Employee createOrUpadteEmployee(Employee employee) {

        Departement departement = null;

        if (employee.getDepartement() != null) {
             departement = departementRepositorie.findById(employee.getDepartement().getId()).orElseThrow();
        }


        if (employee == null ) {
            throw new RestClientException("Un des parametre(s) est null");
        }

        if (employee.getId() == null) {
            return employeeRepositorie.saveAndFlush(employee);
        } else {
            Employee employeeForUpdate = employeeRepositorie.getById(employee.getId());

            employeeForUpdate.setNomEmployee(employee.getNomEmployee());
            employeeForUpdate.setPrenomEmployee(employee.getPrenomEmployee());
            employeeForUpdate.setDepartement(departement);

            return employeeRepositorie.saveAndFlush(employeeForUpdate);
        }

    }

    @Override
    public void deleteEmployee(UUID uuidEmployee) {

        if (uuidEmployee == null) {
            throw new RestClientException("Un des parametres est null");
        }

        employeeRepositorie.deleteById(uuidEmployee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return  employeeRepositorie.findAll();
    }
}
