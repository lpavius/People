package fr.formation.people.services;

import fr.formation.people.dtos.AddressCreateDto;
import fr.formation.people.dtos.AddressDto;
import fr.formation.people.entities.Address;
import fr.formation.people.repositories.AddressJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressJpaRepository repository;

    public AddressServiceImpl(AddressJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AddressCreateDto dto) {
        // Grace a la validation dans le controller
        // on fait confiance a la qualité des données.
        // Convertir AdressCreateDto en Address (entité)
        // En ne creant pas l'id, l'id est attribué par la bdd
        Address address = new Address();

        address.setCountry(dto.getCountry()); // Copie country du dto vers l'entité
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        repository.save(address); // Candidat a la sauvegarde en bdd
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AddressDto get(Long id) {
        Address address = repository.findById(id).get();
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet()); // Copie street de l'entité vers le DTO
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setCountry(address.getCountry());
        return dto;
    }

    public Address getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Address> getAddresses() {
        return repository.findAll();
    }


}
