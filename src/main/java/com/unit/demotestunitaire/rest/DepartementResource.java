package com.unit.demotestunitaire.rest;

import com.unit.demotestunitaire.domain.Departement;
import com.unit.demotestunitaire.service.DepartementService;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DepartementResource {

    private final Logger log =  LoggerFactory.getLogger(DepartementResource.class);

    private static final String ENTITY_NAME = "departement";

    @Autowired
    private DepartementService departementService;


    /**
     * {@code POST  /departements} : Create a new departement.
     *
     * @param departement the departement to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new departement, or with status {@code 400 (Bad Request)} if the departement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/departements")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) throws URISyntaxException {
        System.out.println("REST request to save departement : {}"+ departement);

        Departement result = departementService.createOrUpadteDepartement(departement);
        return ResponseEntity.created(new URI("/api/departements/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("testIntegrationDemo", false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /departements} : Create a new departement.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (Ok)} and with list of departement, or with status {@code 500 (Internal Server error)} if an error occured.
     */
    @GetMapping("/departements")
    public List<Departement> getAllDepartement() {

        return departementService.getAllDepartement();

    }

    /**
     * {@code DELETE  /departements/:id} : delete the "id" departements.
     *
     * @param id the id of the departements to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    //@DeleteMapping("/departements/{id}")
    @RequestMapping(value="/departements/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDepartements(@PathVariable UUID id) {
        System.out.println("REST request to delete departement : {}"+ id);
        departementService.deleteDepartement(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("testIntegrationDemo", false, ENTITY_NAME, id.toString())).build();
    }


}
