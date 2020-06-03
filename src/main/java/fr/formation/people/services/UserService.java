package fr.formation.people.services;

import fr.formation.people.dtos.UserDto;
import fr.formation.people.entities.User;

public interface UserService {

    void create(UserDto user);
}
