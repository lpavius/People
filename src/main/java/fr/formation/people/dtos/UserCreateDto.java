package fr.formation.people.dtos;

import javax.validation.constraints.*;

public class UserCreateDto { // UserCreateDto

    @Size(max = 254) // 256
    @NotNull
    @Email
    private String username;

    @Size(min = 8, max = 20)
    @NotEmpty
    private String password;

    public UserCreateDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password=[PROTECTED]" +
                '}';
    }
}
