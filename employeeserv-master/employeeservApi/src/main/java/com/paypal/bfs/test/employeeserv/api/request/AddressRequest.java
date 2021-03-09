package com.paypal.bfs.test.employeeserv.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class AddressRequest {

    @NotEmpty(message = "line1 should not be blank")
    private String line1;

    private String line2;

    @NotEmpty(message = "city should not be blank")
    private String city;

    @NotEmpty(message = "state should not be blank")
    private String state;

    @NotEmpty(message = "country should not be blank")
    private String country;

    @NotNull(message = "zipcode should not be blank")
    private Integer zipcode;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }
}
