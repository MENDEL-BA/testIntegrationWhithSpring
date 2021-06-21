package com.unit.demotestunitaire.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String nomEmployee;

    private String prenomEmployee;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "dept_id"), name = "dept_id")
    @JsonBackReference
    private Departement departement;


    public Employee(String nomEmployee, String prenomEmployee) {
        this.nomEmployee = nomEmployee;
        this.prenomEmployee = prenomEmployee;
    }

    public Employee() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomEmployee() {
        return nomEmployee;
    }

    public void setNomEmployee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    public String getPrenomEmployee() {
        return prenomEmployee;
    }

    public void setPrenomEmployee(String prenomEmployee) {
        this.prenomEmployee = prenomEmployee;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nomEmployee='" + nomEmployee + '\'' +
                ", prenomEmployee='" + prenomEmployee + '\'' +
                ", departement=" + departement +
                '}';
    }
}
