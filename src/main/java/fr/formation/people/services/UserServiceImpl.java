package fr.formation.people.services;

import fr.formation.people.dtos.UserDto;
import fr.formation.people.entities.Role;
import fr.formation.people.entities.User;
import fr.formation.people.repositories.RoleJpaRepository;
import fr.formation.people.repositories.UserJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    private final RoleJpaRepository roleJpaRepository;

    public UserServiceImpl(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public void create(UserDto dto) {

        User user = new User();
        user.setMail(dto.getMail());
        user.setPassword(dto.getPassword());
        Role role = roleJpaRepository.findByDefaultRoleTrue();
        user.setRole(role);
        userJpaRepository.save(user);
    }
}
