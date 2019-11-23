package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

public class CodeGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailCreator.class);

    public String generateCode(User user) {
        Random generator = new Random();
        int generatedCode = generator.nextInt(1000);
        String firstInitial = String.valueOf(user.getFirstname().charAt(0));
        String code = firstInitial + user.getLastname().charAt(0) + generatedCode;
        LOGGER.info("Booking code has been created");
        return code;
    }
    public CodeGenerator() {
    }
}


