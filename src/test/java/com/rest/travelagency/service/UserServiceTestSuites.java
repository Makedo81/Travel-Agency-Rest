package com.rest.travelagency.service;

import com.rest.travelagency.dao.User;
import com.rest.travelagency.dao.UserDao;
import com.rest.travelagency.domain.user.RegistrationFormDto;
import com.rest.travelagency.domain.user.UserDto;
import com.rest.travelagency.exceptions.LoginAlreadyExistsException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.mapper.UserMapper;
import com.rest.travelagency.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTestSuites {

    @InjectMocks
    UserService userService;
    @Mock
    UserDao repository;
    @Mock
    UserMapper userMapper;

    @Test
    public void testShouldRegisterUser() {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "testPassword",
                true,
                new ArrayList<>());

        User martin = new User(
                2L,
                "Martin",
                "OConnor",
                "martin@mail",
                124L,
                "martinLogin",
                "martinPassword",
                true,
                new ArrayList<>());
        when(repository.save(martin)).thenReturn(martin);
        repository.save(martin);
        RegistrationFormDto form = new RegistrationFormDto(
                "John",
                "Adams",
                123L,
                "john@mail",
                "johnPassword",
                "martinLogin");
        when(repository.findByLogin("martinLogin")).thenReturn(martin);
        when(repository.findByPassword("johnPassword")).thenReturn(null);
        when(repository.findUserByEmail("john@mail")).thenReturn(null);
        boolean thrown = false;
        //When
        try {
            User result = userService.registerUser(form);
            assertEquals("johnPassword", result.getLogin());

        } catch (LoginAlreadyExistsException e) {
            e.printStackTrace();
            //Then
            verify(repository, times(1)).findByLogin("martinLogin");
            verify(repository, times(0)).save(john);
            verify(repository, times(1)).save(martin);
            thrown = true;
        } catch (NotMatchingDataException o) {
            o.printStackTrace();

        }
        assertTrue(thrown);
    }

    @Test
    public void testShouldGetUser() {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "testPassword",
                true,
                new ArrayList<>());

        UserDto johnDto = new UserDto(
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "johnPassword");
        when(repository.findByLogin("johnLogin")).thenReturn(john);
        //When
        when(userMapper.mapToUserDto(john)).thenReturn(johnDto);
        UserDto resultJohn = userService.getUser("johnLogin");
        //Then
        assertEquals("john@mail", resultJohn.getEmail());
        verify(repository, times(1)).findByLogin("johnLogin");
    }

    @Test
    public void testUpdateUser() {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "johnPassword",
                true,
                new ArrayList<>());

        User martin = new User(
                2L,
                "Martin",
                "OConnor",
                "martin@mail",
                124L,
                "martinLogin",
                "martinPassword",
                false,
                new ArrayList<>());
        when(repository.findByPassword("johnPassword")).thenReturn(john);
        when(repository.findByLogin("martinLogin")).thenReturn(martin);
        when(repository.findByPassword("martinPassword")).thenReturn(martin);
        String value1 = "EMAIL";
        String values2 = "test@email";
        //When
        userService.updateUser(value1, values2, john.getPassword());
        userService.updateUser(value1, values2, martin.getPassword());
        User userMartin = repository.findByLogin("martinLogin");
        User userJohn = repository.findByPassword("johnPassword");
        //Then
        assertEquals("martin@mail", userMartin.getEmail());
        assertEquals("test@email", userJohn.getEmail());
    }

    @Test
    public void testShouldSignInUser() throws NotMatchingDataException {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "johnPassword",
                false,
                new ArrayList<>());

        User martin = new User(
                2L,
                "Martin",
                "OConnor",
                "martin@mail",
                124L,
                "martinLogin",
                "martinPassword",
                false,
                new ArrayList<>());
        when(repository.findByLoginAndPassword("johnLogin", "johnPassword")).thenReturn(john);
        when(repository.findByLoginAndPassword("martinLogin", "martinPassword")).thenReturn(martin);
        when(repository.findByLogin("johnPassword")).thenReturn(john);
        when(repository.findByLogin("martinPassword")).thenReturn(martin);
        //When
        userService.signIn(john.getLogin(), john.getPassword());
        User resultJohn = repository.findByLogin("johnPassword");
        User resultMartin = repository.findByLogin("martinPassword");
        assertFalse(resultMartin.isSignIn());
        userService.signIn(martin.getLogin(), martin.getPassword());
        //Then
        assertTrue(resultJohn.isSignIn());
        assertTrue(resultMartin.isSignIn());
    }

    @Test
    public void testShouldSignOutUser() {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "testPassword",
                true,
                new ArrayList<>());

        User martin = new User(
                2L,
                "Martin",
                "OConnor",
                "martin@mail",
                124L,
                "martinLogin",
                "martinPassword",
                true,
                new ArrayList<>());
        when(repository.findByLogin("johnLogin")).thenReturn(john);
        when(repository.save(john)).thenReturn(john);
        when(repository.findByLogin("martinLogin")).thenReturn(martin);
        //When
        userService.signOut("johnLogin");
        User resultJohn = repository.findByLogin("johnLogin");
        User martinBeforeSignOUt = repository.findByLogin("martinLogin");
        assertTrue(martinBeforeSignOUt.isSignIn());
        User resultMartin = repository.findByLogin("martinLogin");
        userService.signOut("martinLogin");
        //Then
        assertFalse(resultJohn.isSignIn());
        assertFalse(resultJohn.isSignIn());
        assertFalse(resultMartin.isSignIn());
    }
}
