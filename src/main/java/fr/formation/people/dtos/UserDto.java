package fr.formation.people.dtos;

import javax.validation.constraints.*;

public class UserDto { // UserCreateDto

    @Size(max = 254) // 256
    @NotNull
    @Email
    private String mail;

    @Size(min = 8, max = 20)
    @NotEmpty
    private String password;

    public UserDto(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
                "mail='" + mail + '\'' +
                ", password=[PROTECTED]" +
                '}';
    }
}
