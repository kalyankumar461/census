package com.population.census.data.service;

import com.population.census.data.entity.Person;
import com.population.census.data.model.PersonModel;
import com.population.census.data.repository.CensusRepository;
import org.springframework.stereotype.Service;

@Service
public class CensusService {

    private final CensusRepository censusRepository;

    public CensusService(CensusRepository censusRepository) {
        this.censusRepository = censusRepository;
    }

    public void savePerson(PersonModel personModel) {
        Person person = new Person();
        person.setName(personModel.getName());
        censusRepository.save(person);
    }
}
