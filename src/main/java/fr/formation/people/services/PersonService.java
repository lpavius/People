package fr.formation.people.services;

import fr.formation.people.dtos.PersonCreateDto;
import fr.formation.people.dtos.PersonDto;
import fr.formation.people.dtos.PersonWithAddressDto;
import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersons();

    void create(PersonWithAddressDto dto);

    //void savePersonWithAddress(Person person, Address address);

    PersonDto get(Long id);

    void delete(Long id);
}
