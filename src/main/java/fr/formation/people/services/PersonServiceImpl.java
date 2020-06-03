package fr.formation.people.services;

import fr.formation.people.dtos.PersonDto;
import fr.formation.people.dtos.PersonWithAddressDto;
import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;
import fr.formation.people.repositories.AddressJpaRepository;
import fr.formation.people.repositories.PersonJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonJpaRepository repository;

    private final AddressJpaRepository addressRepository;

    private final AddressService addressService;

    public PersonServiceImpl(PersonJpaRepository repository,
                             AddressJpaRepository addressRepository,
                             AddressService addressService) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @Override
    public List<Person> getPersons() {
        return repository.findAll();
    }

    @Override
    public void create(PersonWithAddressDto dto) {
        Person person = new Person();
        Address address = addressService.getById(dto.getAddress_id());
        //Address address = addressRepository.findById(dto.getAddress_id());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setBirthDate(dto.getBirthDate());
        person.setAddress_id(address);
        repository.save(person);
    }

    @Override
    public PersonDto get(Long id) {
        Person person = repository.findById(id).get();
        PersonDto dto = new PersonDto();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        return dto;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
