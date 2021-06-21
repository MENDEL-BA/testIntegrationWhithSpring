package com.unit.demotestunitaire.service.serviceImpl;


import com.unit.demotestunitaire.domain.Departement;
import com.unit.demotestunitaire.repositorie.DepartementRepositorie;
import com.unit.demotestunitaire.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepositorie departementRepositorie;

    @Override
    public Departement createOrUpadteDepartement(Departement departement) {

        System.out.println("le dpt "+departement.toString());

        if (departement == null && departement.getNomService() == null) {
            throw new RestClientException("Un des parametre(s) est null");
        }

        if (departement.getId() == null) {
            return departementRepositorie.saveAndFlush(departement);
        } else {

            Departement departementForUpdate = departementRepositorie.getById(departement.getId());

            if(departementForUpdate == null ) {
                throw new RestClientException("Ce departement n'existe pas");
            }

            departementForUpdate.setNomService(departement.getNomService());

            return departementRepositorie.saveAndFlush(departementForUpdate);
        }
    }

    @Override
    public void deleteDepartement(UUID uuidDepartement) {

        if (uuidDepartement == null) {
            throw new RestClientException("Un des parametres est null");
        }

        departementRepositorie.deleteById(uuidDepartement);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepositorie.findAll();
    }
}
