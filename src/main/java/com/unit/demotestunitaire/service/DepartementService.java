package com.unit.demotestunitaire.service;

import com.unit.demotestunitaire.domain.Departement;

import java.util.List;
import java.util.UUID;

public interface DepartementService {

    Departement createOrUpadteDepartement(Departement departement);

    void deleteDepartement(UUID uuidDepartement);

    List<Departement> getAllDepartement();
}
