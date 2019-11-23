package com.rest.travelagency;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    @Value("${admin.mail}")
    public String adminMail;

    public String getAdminMail() {
        return adminMail;
    }

    public AdminConfig() {
    }
}
