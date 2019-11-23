package com.rest.travelagency.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationFormDto {

    private String firstname;
    private String lastname;
    private Long phoneNumber;
    private String email;
    private String password;
    private String login;
}