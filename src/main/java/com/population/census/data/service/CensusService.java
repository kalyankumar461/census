package com.population.census.data.service;

import com.population.census.data.entity.Address;
import com.population.census.data.entity.Person;
import com.population.census.data.model.AddressModel;
import com.population.census.data.model.PersonModel;
import com.population.census.data.repository.CensusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CensusService {

    private final CensusRepository censusRepository;

    public CensusService(CensusRepository censusRepository) {
        this.censusRepository = censusRepository;
    }

    public void savePerson(PersonModel personModel) {
        Person person = new Person();
        person.setFirstName(personModel.getFirstName());
        person.setLastName(personModel.getLastName());
        person.setGender(personModel.getGender());

        Address address = new Address();
        address.setArea(personModel.getAddressModel().getArea());
        address.setCountry(personModel.getAddressModel().getCountry());
        address.setState(personModel.getAddressModel().getState());
        address.setPincode(personModel.getAddressModel().getPincode());

        person.setAddress(address);

        censusRepository.save(person);
    }

    public List<PersonModel>  fetchAllPersons() {

        List<Person> personList =
                censusRepository.findAll();

        List<PersonModel> personModelList = new ArrayList<>();

        for(Person person : personList) {
            PersonModel personModel = new PersonModel();
            personModel.setFirstName(person.getFirstName());
            personModel.setLastName(person.getLastName());
            personModel.setGender(person.getGender());


            if(person.getAddress() != null) {
                AddressModel addressModel = new AddressModel();
                addressModel.setArea(person.getAddress().getArea());
                addressModel.setCountry(person.getAddress().getCountry());
                addressModel.setPincode(person.getAddress().getPincode());
                addressModel.setState(person.getAddress().getState());
                personModel.setAddressModel(addressModel);
            }


            personModelList.add(personModel);
        }

        return personModelList;

    }
}
