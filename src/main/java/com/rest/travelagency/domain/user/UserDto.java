package com.rest.travelagency.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstname;
    private String lastname;
    private String email;
    private Long phoneNumber;
    private String login;
    private String password;
    private boolean isSignIn;

    public UserDto(String firstname, String lastname, String email, Long phoneNumber, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }
}
