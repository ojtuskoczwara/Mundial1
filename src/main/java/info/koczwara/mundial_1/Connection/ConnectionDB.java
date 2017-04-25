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


    public static void close(PreparedStatement statement, ResultSet resultSet) throws Exception {
        if (statement != null) {
            statement.close();
            System.out.println("Statement close.");
        }
        if (resultSet != null) {
            resultSet.close();
            System.out.println("ResultSet close.");
        }
    }

    public static void disconnect(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
            System.out.println("Połączenie z bazą danych zostało zamknięte.");
        }
    }
}
