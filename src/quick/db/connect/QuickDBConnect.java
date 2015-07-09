package quick.db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import quick.db.exceptions.InvalidInputException;
import quick.db.exceptions.VendorNotFoundException;

/**
 * This class will create a database Connection without 
 * the user needing to specify the driver and URL
 * 
 * @author JordanF
 */
public class QuickDBConnect {

    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String MYSQL_URL = "jdbc:mysql://";
    private static final String ORACLE_URL = "jdbc:oracle:thin:@";

    public static enum Vendor {

        ORACLE, MYSQL
    }

    public static Connection getConnection(String vendor, String hostname, 
            String port, String schema, String username, String password)
            throws  InvalidInputException, VendorNotFoundException, Exception {
        
        Connection conn = null;
        String url = null;
        String driver = null;
        if (vendor == null || hostname == null || port == null || schema == null
                || username == null || password == null) {
            throw new InvalidInputException("One or more of the input"
                    + " parameters is null");
        }
        
        switch (vendor.toUpperCase()) {
            case "ORACLE":
                driver = ORACLE_DRIVER;
                url = ORACLE_URL + hostname + ":" + port + ":" + schema;
                break;
            case "MYSQL":
                driver = MYSQL_DRIVER;
                url = MYSQL_URL  + hostname + ":" + port + "/" + schema;
                break;
            default:
                throw new VendorNotFoundException("'" + vendor + "' is not"
                        + " a valid vendor. Select from "
                        + Arrays.toString(Vendor.values()));
        }

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new InvalidInputException("Unable to connect to database "
                    + "with given input: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new Exception("Unable to find driver class: " 
                    + ex.getMessage());
        }

        return conn;
    }

}
