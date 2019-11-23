package com.rest.travelagency.service.user;

import com.rest.travelagency.dao.User;
import com.rest.travelagency.dao.UserDao;
import com.rest.travelagency.domain.user.RegistrationFormDto;
import com.rest.travelagency.domain.user.UserDto;
import com.rest.travelagency.exceptions.LoginAlreadyExistsException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    private UpdateProcessor updateProcessor = new UpdateProcessor();
    private LoginActionValidator loginActionValidator = new LoginActionValidator();

    public UserDto getUser(final String login) {
        User user = userDao.findByLogin(login);
        LOGGER.info("Fetching available deals");
        return userMapper.mapToUserDto(user);
    }

    public User registerUser(final RegistrationFormDto registrationFormDto) throws LoginAlreadyExistsException, NotMatchingDataException {
        User user = new User();
        String login = registrationFormDto.getLogin();
        String password = registrationFormDto.getPassword();
        String email = registrationFormDto.getEmail();
        if (checkIfExist(login, password, email)) {
            user.setFirstname(registrationFormDto.getFirstname());
            user.setLastname(registrationFormDto.getLastname());
            user.setEmail(registrationFormDto.getEmail());
            user.setPhoneNumber(registrationFormDto.getPhoneNumber());
            user.setPassword(registrationFormDto.getPassword());
            user.setLogin(registrationFormDto.getLogin());
            userDao.save(user);
            LOGGER.info("Created new user");
            return user;
        } else {
            throw new LoginAlreadyExistsException("User with following login,password or email already exists.");
        }
    }

    public void signIn(final String login, final String password) throws NotMatchingDataException {
        if (loginActionValidator.validateLoginAction(login, password)) {
            User user = userDao.findByLoginAndPassword(login, password);
            user.setSignIn(true);
            userDao.save(user);
            LOGGER.info("User succesfully sign in");
        } else {
            LOGGER.info("Data do not match");
            throw new NotMatchingDataException("Data entry do not result in database. Enter the correct data");
        }
    }

    public void signOut(final String login) {
        User user = userDao.findByLogin(login);
        user.setSignIn(false);
        userDao.save(user);
        LOGGER.info("User succesfully sign out");
    }

    public void updateUser(final String value1, final String value2,final String password) {
        User user = userDao.findByPassword(password);
        updateProcessor.updateDataPicker(user,value1,value2);
            userDao.save(user);
    }

    public void deleteUser(final String password) {
        User user = userDao.findByPassword(password);
        if (user.isSignIn()) {
            Long id = user.getId();
            userDao.deleteById(id);
            LOGGER.info("User account removed");
        } else LOGGER.error("User has to be log in to delete account");
    }

    private boolean checkIfExist(final String login, final String password, final String email) throws NotMatchingDataException {
        if (email.contains("@")) {
            User userWithLogin = userDao.findByLogin(login);
            User userWithPassword = userDao.findByPassword(password);
            User userWithEmail = userDao.findUserByEmail(email);
            if (userWithLogin == null && userWithPassword == null && userWithEmail == null) {
                return true;
            } else return false;
        } else throw new NotMatchingDataException("Email incorrect");
    }
}