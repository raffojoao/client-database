package localhost.clientdb.util;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connection = null;
    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/client_database",
                            "postgres", "961023");
            JOptionPane.showMessageDialog(null,
                    "Successfully connected do Database",
                    "DB Connection",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to connect to server \n" +
                            "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        new DBConnection().getConnection();
    }
}
