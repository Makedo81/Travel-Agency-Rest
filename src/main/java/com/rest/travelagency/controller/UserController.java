package com.rest.travelagency.controller;

import com.rest.travelagency.domain.user.RegistrationFormDto;
import com.rest.travelagency.domain.user.UserDto;
import com.rest.travelagency.exceptions.LoginAlreadyExistsException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.mapper.UserMapper;
import com.rest.travelagency.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/registerUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto registerUser(@RequestBody RegistrationFormDto registrationFormDto) throws LoginAlreadyExistsException, NotMatchingDataException {
        return userMapper.mapToUserDto(userService.registerUser(registrationFormDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/signIn")
    public void signIn(@RequestParam String login, @RequestParam String password) throws NotMatchingDataException {
        userService.signIn(login, password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/signOut", consumes = APPLICATION_JSON_VALUE)
    public void signOut(@RequestParam String login) {
        userService.signOut(login);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public void delete(@RequestParam String password) {
        userService.deleteUser(password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void update(@RequestParam(value = "value1") String value1, @RequestParam(value = "value2") String value2, @RequestParam(value = "password") String password) {
        userService.updateUser(value1, value2, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public UserDto getUser(@RequestParam(value = "login") String login) {
        return userService.getUser(login);
    }
}
