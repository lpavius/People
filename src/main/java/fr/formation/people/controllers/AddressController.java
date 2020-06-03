package fr.formation.people.controllers;

import javax.validation.Valid;

import fr.formation.people.dtos.AddressDto;
import fr.formation.people.services.AddressService;
import org.springframework.web.bind.annotation.*;

import fr.formation.people.dtos.AddressCreateDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin
public class AddressController {

    // inject une instance de AdressServiceImpl
    // AddressServiceImpl doit etre annoté @Service
    // @Autowired ou par constructeur
    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping("/address") // POST "/addresses" avec un JSON dans le corps de la requête
    public void create(@RequestBody @Valid AddressCreateDto dto) {
        service.create(dto);
    }

    @GetMapping("/addresses")
    public List<AddressDto> getAll() {
        return service.getAddresses().stream()
                .map(address -> new AddressDto( address.getId(),
                                                address.getCountry(),
                                                address.getStreet(),
                                                address.getCity(),
                                                address.getZipCode()))
                .collect(Collectors.toList());
    }


    @GetMapping("/address/{id}") // GET "/addresses/1" ou 1 correspond à l'id d'une adresse existante en bdd
    public AddressDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}") // DELETE "/addresses/1" ou 1 correspond à l'id d'une adresse existante en bdd
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
