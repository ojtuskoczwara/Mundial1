package info.koczwara.mundial_1.Model.DAOImplementation;

import info.koczwara.mundial_1.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.Zawodnik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikDAOImpl implements ZawodnikDAO {

    private Connection connection = ConnectionDB.getConnection();

    public void addZawodnik(Zawodnik zawodnik) throws SQLException {
        String sql = "INSERT INTO Zawodnik(imie,nazwisko) VALUES(?,?)";
            //Preparation
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,zawodnik.getImie());
            statement.setString(2, zawodnik.getNazwisko());
            //Execution
            statement.executeUpdate();
    }

    public Zawodnik getZawodnikById(int id) throws Exception {
        String sql = "SELECT * FROM Zawodnik WHERE idZawodnika = ?";
        Zawodnik zawodnik = null;
        //Preparation
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        //Execution
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            zawodnik = new Zawodnik();
            zawodnik.setIdZawodnika(result.getInt("idZawodnika"));
            zawodnik.setImie(result.getString("imie"));
            zawodnik.setNazwisko(result.getString("nazwisko"));
        }
        ConnectionDB.disconnect(statement, result, connection);
        return zawodnik;
    }

    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM Zawodnik WHERE imie = ? AND nazwisko = ?";
        //Preparation
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,imie);
        statement.setString(2, nazwisko);
        ResultSet results = statement.executeQuery();
        System.out.println(statement);
        while (results.next()) {
            //int id = results.getInt("idZawodnika");
            //String firstName = results.getString("imie");
            //String lastName = results.getString("nazwisko");
            //Zawodnik zawodnik = new Zawodnik(firstName,lastName);
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.disconnect(statement, results, connection);
        return zawodnicy;
    }


    public List<Zawodnik> getAllZawodnik() throws SQLException {
        return null;
    }

    public void updateZawodnik(Zawodnik zawodnik) throws SQLException {

    }

    public void deleteZawodnik(int idZawodnika) throws SQLException {

    }
}
