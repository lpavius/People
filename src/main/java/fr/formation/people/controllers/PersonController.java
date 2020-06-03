package fr.formation.people.controllers;

import fr.formation.people.dtos.PersonCreateDto;
import fr.formation.people.dtos.PersonDto;
import fr.formation.people.dtos.PersonWithAddressDto;
import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;
import fr.formation.people.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Définir un ensemble de endpoints
// pour un  type de ressources (Person)

@RestController // Ceci est un controller, tiens en compte
@RequestMapping("/person") // correspondance url/code
// http://localhost:8082/persons
@CrossOrigin(origins = "*")
public class PersonController {

    // GET, POST, DELETE

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<PersonDto> getPersons() {
        List<PersonDto> personDto = new ArrayList<>();
        for (Person person: service.getPersons()) {
            personDto.add(new PersonDto(person.getId(), person.getFirstName(), person.getLastName()));
        }
        return personDto;
    }

    // GET http://localhost:8082/persons
    // 123 = path variable (variable de chemin)
    @GetMapping("/{id}")
    public PersonDto get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    // @RequestBody = extraire et convertir le JSON du corp (body)
    // de la requête HTTP vers une instance de PersonCreateDto
    // @Valid: cascader la validation sur de DTO
    @PostMapping
    public String create(@RequestBody @Valid PersonWithAddressDto dto) {
        service.create(dto);
        return "OK";
    }
}
