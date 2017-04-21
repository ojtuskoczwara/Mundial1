package info.koczwara.mundial_1.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {

    public static Connection connect() throws Exception {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");

        String USER = "tutorial";
        String PASSWORD = "password";
        String DB_URL = "jdbc:mysql://localhost:3306/mojaBaza"+"?verifyServerCertificate=false&useSSL=true";

        con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("Połączono z bazą danych.");
        return con;
    }


    public static void disconnect(PreparedStatement statement, ResultSet resultSet, Connection connection) throws Exception {
        System.out.println("Zamykanie połączenia z bazą danych.");
        if (statement != null) {
            statement.close();
            System.out.println("Statement close.");
        }
        if (resultSet != null) {
            resultSet.close();
            System.out.println("ResultSet close.");
        }
        if (connection != null) {
            connection.close();
            System.out.println("Connection close.");
        }
    }
}
