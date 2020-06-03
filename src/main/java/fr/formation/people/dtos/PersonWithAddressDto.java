package fr.formation.people.dtos;

import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonWithAddressDto {

    @NotNull
    @Length(min = 3)
    private String firstName;

    @NotNull
    @Length(min = 3)
    private String lastName;

    private LocalDate birthDate;

    private Long address_id;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "PersonWithAddressDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address_id=" + address_id +
                '}';
    }
}
