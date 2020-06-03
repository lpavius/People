package fr.formation.people.services;

import fr.formation.people.entities.User;
import fr.formation.people.repositories.UserJpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserdetailsServiceImpl implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public UserdetailsServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("no user found with username");
        }
        return toSpringUser(user);
    }

    private static org.springframework.security.core.userdetails.User toSpringUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        boolean enabled = user.isEnabled();
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getCode());// ROLE_USER
        authorities.add(authority);
        return new org.springframework.security
                .core.userdetails
                .User(username,
                    password,
                    enabled, true, true, true, authorities);
    }
}
