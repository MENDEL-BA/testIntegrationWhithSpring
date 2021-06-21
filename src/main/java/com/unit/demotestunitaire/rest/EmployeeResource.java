package com.unit.demotestunitaire.rest;


import com.unit.demotestunitaire.domain.Departement;
import com.unit.demotestunitaire.domain.Employee;
import com.unit.demotestunitaire.service.EmployeeService;
import io.github.jhipster.web.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private static final String ENTITY_NAME = "employee";

    @Autowired
    private EmployeeService employeeService;


    /**
     * {@code POST  /employee} : Create a new departement.
     *
     * @param employee the employee to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new employee, or with status {@code 400 (Bad Request)} if the employee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws URISyntaxException {
        System.out.println("REST request to save employee : {}"+ employee);

        Employee result = employeeService.createOrUpadteEmployee(employee);
        return ResponseEntity.created(new URI("/api/employees/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("testIntegrationDemo", false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /employee} : Create a new employee.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (Ok)} and with list of employee, or with status {@code 500 (Internal Server error)} if an error occured.
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {

        return employeeService.getAllEmployee();

    }

    /**
     * {@code DELETE  /employees/:id} : delete the "id" departements.
     *
     * @param id the id of the employees to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    //@DeleteMapping("/departements/{id}")
    @RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        System.out.println("REST request to delete employee : {}"+ id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("testIntegrationDemo", false, ENTITY_NAME, id.toString())).build();
    }
}
