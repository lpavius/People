package fr.formation.people.services;

import fr.formation.people.dtos.UserCreateDto;
import fr.formation.people.entities.Role;
import fr.formation.people.entities.User;
import fr.formation.people.repositories.RoleJpaRepository;
import fr.formation.people.repositories.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    private final RoleJpaRepository roleJpaRepository;

    private final PasswordEncoder encoder;

    public UserServiceImpl(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.encoder = passwordEncoder;
    }

    @Override
    public void create(UserCreateDto dto) { // changer par UserCreateDto
        User user = new User();
        user.setUsername(dto.getUsername());
        String rawPassword = dto.getPassword();
        String encodePassword = encoder.encode(rawPassword);
        user.setPassword(encodePassword);
        Role role = roleJpaRepository.findByDefaultRoleTrue();
        user.setRole(role);
        user.setEnabled(true);
        userJpaRepository.save(user);
    }
}
