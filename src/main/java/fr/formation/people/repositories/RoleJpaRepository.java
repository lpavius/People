package fr.formation.people.repositories;

import fr.formation.people.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {

    Role findByDefaultRoleTrue();
}
