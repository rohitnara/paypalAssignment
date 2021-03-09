package com.paypal.bfs.test.employeeserv.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paypal.bfs.test.employeeserv.api.entity.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EmployeeRequest {

    @Size(min = 1, max = 255, message = "first_name length should be in between 1 to 255")
    @NotNull(message = "first_name should not be blank")
    @JsonProperty("first_name")
    private String firstName;

    @Size(min = 1, max = 255, message = "first_name length should be in between 1 to 255")
    @NotEmpty(message = "last_name should not be blank")
    @JsonProperty("last_name")
    private String lastName;

    @Valid
    @NotNull(message = "address should not be blank")
    @JsonProperty("address")
    private AddressRequest address;

    @NotNull(message = "date_of_birth should not be blank")
    @JsonProperty("date_of_birth")
    private String dob;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}