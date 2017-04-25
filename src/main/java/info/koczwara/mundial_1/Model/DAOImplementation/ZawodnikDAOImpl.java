package info.koczwara.mundial_1.Model.DAOImplementation;

import info.koczwara.mundial_1.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.Zawodnik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikDAOImpl implements ZawodnikDAO {
    Connection connection = ConnectionDB.connect();
    public ZawodnikDAOImpl() throws Exception {
    }

    public void addZawodnik(Zawodnik zawodnik) throws Exception {
        String sql = "INSERT INTO Zawodnik(imie,nazwisko) VALUES(?,?)";
        PreparedStatement statement = null;
            //Preparation
            statement = connection.prepareStatement(sql);
            statement.setString(1,zawodnik.getImie());
            statement.setString(2, zawodnik.getNazwisko());
            //Execution
            statement.executeUpdate();
            ConnectionDB.close(statement, null);
    }

    public Zawodnik getZawodnikById(int id) throws Exception {
        String sql = "SELECT * FROM Zawodnik WHERE idZawodnika = ?";
        Zawodnik zawodnik = null;
        //Connection
        Connection connection = ConnectionDB.connect();
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
        ConnectionDB.close(statement, result);
        return zawodnik;
    }

    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM Zawodnik WHERE imie = ? AND nazwisko = ?";
        //Connection
        Connection connection = ConnectionDB.connect();
        //Preparation
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,imie);
        statement.setString(2, nazwisko);
        ResultSet results = statement.executeQuery();
        System.out.println(statement);
        while (results.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.close(statement, results);
        return zawodnicy;
    }


    public List<Zawodnik> getAllZawodnik() throws Exception {
        String sql = "SELECT * FROM Zawodnik";
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(result.getString("imie"));
            zawodnik.setNazwisko(result.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.close(statement, result);
        return zawodnicy;
    }

    public void updateZawodnik(Zawodnik zawodnik) throws SQLException {

    }

    public void deleteZawodnik(int idZawodnika) throws Exception {
        String sql = "DELETE FROM Zawodnik WHERE idZawodnika=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,idZawodnika);
        statement.executeUpdate();
        ConnectionDB.close(statement,null);
    }
}
