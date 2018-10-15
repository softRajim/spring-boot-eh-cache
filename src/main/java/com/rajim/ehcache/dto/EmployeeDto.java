package com.rajim.ehcache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rajim on 10/14/18
 */
@Setter
@Getter
public class EmployeeDto {

    private String name;

    private double salary;

    @JsonProperty("address_line1")
    private String addressLine1;

    @JsonProperty("zip_code")
    private String zipCode;

    private String city;
}
