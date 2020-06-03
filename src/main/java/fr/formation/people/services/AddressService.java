package fr.formation.people.services;

import fr.formation.people.dtos.AddressCreateDto;
import fr.formation.people.dtos.AddressDto;
import fr.formation.people.entities.Address;

import java.util.List;

public interface AddressService {

    void create(AddressCreateDto dto);

    void delete(Long id);

    AddressDto get(Long id);

    Address getById(Long id);

    List<Address> getAddresses();
}
