package fr.formation.people.controllers;

import fr.formation.people.dtos.UserDto;
import fr.formation.people.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody @Valid UserDto userDto) {
        userService.create(userDto);
    }
}
