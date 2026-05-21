package com.population.census.data.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressModel {

    private String area;
    private String state;
    private String country;
    private String pincode;
}
