package com.rest.travelagency;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

    private Connection conn;
    private static DbManager dbManagerInstance;
    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    /**
     * *  MySql database settings
     */

//    private DbManager() throws SQLException {
//        Properties connectionProps = new Properties();
//        connectionProps.put("user", "admin");
//        connectionProps.put("password", "travel");
//        conn = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/travel_agency?serverTimezone=Europe/Warsaw&useSSL=False",
//                connectionProps);
//    }

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "sa");
        connectionProps.put("password", "sa");
        conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS travel",
                connectionProps);
    }


    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        System.out.println(conn.toString());
        return conn;
    }

    /**
     * *  MySql call event method
     */

//    public void callEvent() throws SQLException {
//        LOGGER.info("Event has been called");
//        DbManager dbManager = getInstance();
//        Statement statementDrop = dbManager.getConnection().createStatement();
//        Statement statementCreate = dbManager.getConnection().createStatement();
//        if (getInstance() != null) {
//            String sql2 = "DROP EVENT IF EXISTS cleaningEvent;";
//            String sql1 = "CREATE EVENT cleaningEvent\n" +
//                    "    ON SCHEDULE EVERY 10 minute\n" +
//                    "    DO\n" +
//                    "      CALL deleteOldBookings();";
//            statementDrop.executeUpdate(sql2);
//            statementCreate.executeUpdate(sql1);
//        }
//    }

    public void readFile() throws FileNotFoundException {
        String file1 = "src/main/resources/file/DatabaseDataInput.sql";
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        ScriptRunner sr = new ScriptRunner(conn);
        sr.runScript(reader);
    }
}
