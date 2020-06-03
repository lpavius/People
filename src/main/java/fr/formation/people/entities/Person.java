package fr.formation.people.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname",length = 20, nullable = false)
    private String firstName;

    @Column(name = "lastname",length = 20, nullable = false)
    private String lastName;

    @Column(name = "birthdate",nullable = false)
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Address address;

    public Person() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Address getAddress_id() {
        return address;
    }

    public void setAddress_id(Address address_id) {
        this.address = address_id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address_id=" + address +
                '}';
    }
}
