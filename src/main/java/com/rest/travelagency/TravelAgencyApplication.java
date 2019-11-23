package com.rest.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.sql.SQLException;

import static com.rest.travelagency.DbManager.getInstance;

@SpringBootApplication
public class TravelAgencyApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(TravelAgencyApplication.class, args);
        DbManager object = getInstance();
   //     object.callEvent();

        try {
            object.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


