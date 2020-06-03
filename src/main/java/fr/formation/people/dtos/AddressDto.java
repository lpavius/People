package fr.formation.people.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddressDto {


    private Long id;

    @NotNull
    @Length(min = 2)
    private String country;

    @NotNull
    @Length(min = 2)
    private String street;

    @NotNull
    @Length(min = 2)
    private String city;

    @NotNull
    @Length(min = 2)
    private String zipCode;

    public AddressDto() {
        //
    }

    public AddressDto(Long id, String country, String street, String city, String zipCode) {
        this.id = id;
        this.country = country;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
