package com.unit.demotestunitaire.repositorie;

import com.unit.demotestunitaire.domain.Departement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DepartementRepositorie extends JpaRepository< Departement, UUID> {


    List<Departement> findAll(Sort sort);
}
