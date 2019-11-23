package com.rest.travelagency.service.user;

import com.rest.travelagency.exceptions.NotMatchingDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginActionValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginActionValidator.class);

    public boolean validateLoginAction(final String login, final String password) throws NotMatchingDataException {
        if (!(login.equals("") || password.equals(""))) {
            LOGGER.info("Login data are correct");
            return true;
        } else {
            LOGGER.info("Data do not match");
            throw new NotMatchingDataException("Data entry do not result in database. Enter the correct data");
        }
    }
}


