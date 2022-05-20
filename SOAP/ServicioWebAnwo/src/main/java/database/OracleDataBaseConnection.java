/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cgomezvega
 */
public class OracleDataBaseConnection {
    
    private final String driver;
    private final String hostName;
    private final String jdbcPort;
    private final String sid;
    private final String user;
    private final String password;
    private final String url;
    
    public OracleDataBaseConnection() {
        this.driver = "thin";
        this.hostName = "127.0.0.1";
        this.jdbcPort = "1521";
        this.sid = "XE";
        this.user = "c##USERANWO";
        this.password = "oracle";
        this.url = getUrlString();
    }
    
    public OracleDataBaseConnection(String driver, String hostName
            , String jdbcPort, String sid, String user, String password) {
        this.driver = driver;
        this.hostName = hostName;
        this.jdbcPort = jdbcPort;
        this.sid = sid;
        this.user = user;
        this.password = password;
        this.url = getUrlString();
    }
    
    public Connection getConnection() {
       try {
            DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public String getDriver() {
        return driver;
    }

    public String getHostName() {
        return hostName;
    }

    public String getJdbcPort() {
        return jdbcPort;
    }

    public String getSid() {
        return sid;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUrl() {
        return url;
    }

    protected String getUrlString() {
        return "jdbc:oracle:driver:@hostName:jdbcPort/sid"
                .replace("driver", this.driver)
                .replace("hostName", this.hostName)
                .replace("jdbcPort", this.jdbcPort)
                .replace("sid", this.sid);
    }
}