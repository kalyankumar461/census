package com.population.census.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.population.census.data.model.enums.Gender;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonModel {

    private String firstName;
    private String lastName;
    private Gender gender;

    @JsonProperty("address")
    private AddressModel addressModel;
}
