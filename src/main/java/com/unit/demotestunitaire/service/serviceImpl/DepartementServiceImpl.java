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

        if (departement.getId() == null) {
            Departement departementSave = new Departement();
            departementSave.setNomService(departement.getNomService());
            return departementRepositorie.saveAndFlush(departementSave);
        } else {

            Departement departementForUpdate = departementRepositorie.getById(departement.getId());

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
    public Departement getByNomService(String nomService) {
        if (nomService == null) {
            throw new RestClientException("Un des parametres est null");
        }

        return departementRepositorie.findByNomService(nomService);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepositorie.findAll();
    }
}
