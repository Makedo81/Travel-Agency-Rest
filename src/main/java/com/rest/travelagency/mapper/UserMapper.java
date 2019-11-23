package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.User;
import com.rest.travelagency.domain.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getLogin(),
                user.getPassword());
    }
}
