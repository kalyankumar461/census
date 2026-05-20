package com.population.census.data.controller;

import com.population.census.data.model.PersonModel;
import com.population.census.data.service.CensusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CensusController {

    private final CensusService censusService;

    public CensusController(CensusService censusService) {
        this.censusService = censusService;
    }

    @PostMapping("/create/person")
    public ResponseEntity<String> createPersonEntry(@RequestBody PersonModel personModel) {
        censusService.savePerson(personModel);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }


}
