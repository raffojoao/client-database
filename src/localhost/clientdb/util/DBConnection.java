package localhost.clientdb.util;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

    public static Connection connection = null;
    public static ResourceBundle settings = ResourceBundle.getBundle(Constants.FILEPATH);
    public static Connection getConnection(){

        try {
            Class.forName(settings.getString(Constants.DRIVER));
            connection = DriverManager.getConnection(settings.getString(Constants.URL),
                                                        settings.getString(Constants.USER),
                                                        settings.getString(Constants.PASSWORD));
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
