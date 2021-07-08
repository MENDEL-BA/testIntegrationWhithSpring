package com.unit.demotestunitaire.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Departement {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String nomService;


    public Departement(UUID id) {
        this.id = id;
    }

    public Departement(UUID id, String nomService) {
        this.id = id;
        this.nomService = nomService;
    }

    public Departement(String nomService) {
        this.nomService = nomService;
    }

    public Departement(UUID id, String nomService, List<Employee> employees) {
        this.id = id;
        this.nomService = nomService;
    }

    public Departement() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nomService='" + nomService + '\'' +
                '}';
    }
}

