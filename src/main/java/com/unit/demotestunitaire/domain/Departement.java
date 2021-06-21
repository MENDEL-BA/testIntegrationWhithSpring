package com.unit.demotestunitaire.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Departement {

    @Id
    @GeneratedValue
    private UUID id;

    private String nomService;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference
    private List<Employee> employees;

    public Departement(UUID id) {
        this.id = id;
    }

    public Departement(UUID id, String nomService, List<Employee> employees) {
        this.id = id;
        this.nomService = nomService;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nomService='" + nomService + '\'' +
                '}';
    }
}

