package com.unit.demotestunitaire;

import com.unit.demotestunitaire.domain.Employee;
import com.unit.demotestunitaire.repositorie.EmployeeRepositorie;
import com.unit.demotestunitaire.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTestUnitaireApplicationTests {


        @MockBean
        private EmployeeRepositorie employeeRepositorie;

        @Autowired
        private EmployeeService employeeService;

        @Test
        public void getEmployeeTest() {
            when(employeeRepositorie.findAll()).thenReturn(Stream
                    .of(new Employee("uchiha","sasuke"), new Employee("uzumaki", "naruto"))
                    .collect(Collectors.toList()));
            Assert.assertEquals(2, employeeService.getAllEmployee().size());
        }

       @Test
       public void saveEmployeTest() {
            Employee employee = new Employee("mami", "sunade");
            when(employeeRepositorie.saveAndFlush(employee)).thenReturn(employee);
            Assert.assertEquals(employee, employeeService.createOrUpadteEmployee(employee));
       }

       @Test
       public void updateEmployeeTest() {

            Employee employee = employeeRepositorie.getEmployeeByNomEmployeeAndPrenomEmployee("mami", "sunade");
            when(employeeRepositorie.saveAndFlush(employee)).thenReturn(employee);
            Assert.assertEquals(employee, employeeService.createOrUpadteEmployee(employee));

       }


}
