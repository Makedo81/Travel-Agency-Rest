package com.rest.travelagency.service.user;

import com.rest.travelagency.dao.User;
import com.rest.travelagency.domain.user.UpdateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateData.class);

    public void updateDataPicker(User user, String value, String value1){
        if (user.isSignIn()) {
            LOGGER.info("user is logged in" + user.isSignIn());
            switch (value) {
                case "LASTNAME":
                    LOGGER.info(value + " is to update");
                    user.setLastname(value1);
                    break;
                case "EMAIL":
                    LOGGER.info(value + " is to update");
                    user.setEmail(value1);
                    break;
                case "PHONE NUMBER":
                    LOGGER.info(value + " is to update");
                    user.setPhoneNumber(Long.valueOf(value1));
                    break;
            }
        } else LOGGER.error("User must be logged in");
    }
}


