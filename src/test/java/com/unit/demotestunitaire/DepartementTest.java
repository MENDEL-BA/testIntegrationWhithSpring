package com.unit.demotestunitaire;

import com.unit.demotestunitaire.domain.Departement;
import com.unit.demotestunitaire.repositorie.DepartementRepositorie;
import com.unit.demotestunitaire.service.DepartementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {


    @MockBean
    private DepartementRepositorie departementRepositorie;

    @Autowired
    private DepartementService departementService;



    @Test
    public void getDepartementTest() {
        when(departementRepositorie.findAll()).thenReturn(Stream
                .of(new Departement(UUID.randomUUID(),"Force Speciale de KONOHA"), new Departement(UUID.randomUUID(), "Section Recherche"))
                .collect(Collectors.toList()));
        Assert.assertEquals(2, departementService.getAllDepartement().size());
    }

    @Test
    public void saveDepartementTest() {
        Departement departement = new Departement("Force Speciale de KONOHA");
        when(departementRepositorie.saveAndFlush(departement)).thenReturn(departement);
        Assert.assertEquals(departement, departementService.createOrUpadteDepartement(departement));
    }


    @Test
    public void updateEmployeeTest() {

        //Departement departement = departementService.getByNomService("Force speciale de KONOHA");
        System.out.println("le departement "+departementService.getByNomService("Force speciale de KONOHA"));
       // when(departementRepositorie.saveAndFlush(departement)).thenReturn(departement);
        //Assert.assertEquals(departement, departementService.createOrUpadteDepartement(departement));

    }

    @Test
    public void getDepartementbyNomserviceTest() {
        String nomService = "Force_speciale_konoha";
        when(departementRepositorie.findByNomService(nomService))
                .thenReturn(new Departement(UUID.randomUUID(), "Force_speciale_konoha"));
        Assert.assertEquals(departementRepositorie.findByNomService(nomService), departementService.getByNomService(nomService));
    }
}
