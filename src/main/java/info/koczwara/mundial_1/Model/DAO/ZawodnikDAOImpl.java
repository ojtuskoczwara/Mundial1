package info.koczwara.mundial_1.Model.DAO;

import info.koczwara.mundial_1.Model.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.Entity.Zawodnik;
import info.koczwara.mundial_1.Model.utils.ParserSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikDAOImpl implements ZawodnikDAO {

    private ParserSQL parserSQL = new ParserSQL();

    public void addZawodnik(Zawodnik zawodnik) throws SQLException {
        String sql = "INSERT INTO Zawodnik(imie,nazwisko) VALUES(?,?)";
        parserSQL.parseQuery(sql, zawodnik.getImie(), zawodnik.getNazwisko())
                .executeUpdate();
    }

    public Zawodnik getZawodnikById(int id) throws Exception {
        String sql = "SELECT * FROM Zawodnik WHERE idZawodnika = ?";
        Zawodnik zawodnik = null;
        ResultSet result = parserSQL.parseQuery(sql, id)
                .executeQuery();
        if (result.next()) {
            zawodnik = new Zawodnik();
            zawodnik.setIdZawodnika(result.getInt("idZawodnika"));
            zawodnik.setImie(result.getString("imie"));
            zawodnik.setNazwisko(result.getString("nazwisko"));
        }
        ConnectionDB.disconnect(result);
        return zawodnik;
    }

    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM Zawodnik WHERE imie = ? AND nazwisko = ?";

        ResultSet results = parserSQL.parseQuery(sql, imie, nazwisko)
                .executeQuery();

        while (results.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.disconnect(results);
        return zawodnicy;
    }


    public List<Zawodnik> getAllZawodnik() throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM Zawodnik";

        ResultSet results = parserSQL.parseQuery(sql).executeQuery();

        while (results.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.disconnect(results);
        return zawodnicy;
    }

    public void updateZawodnik(Zawodnik zawodnik) throws SQLException {
        String sql = "UPDATE Zawodnik SET imie=?, nazwisko=? WHERE idZawodnika=?";
        parserSQL.parseQuery(sql, zawodnik.getIdZawodnika(), zawodnik.getImie(), zawodnik.getNazwisko()).executeUpdate();
    }

    public void deleteZawodnik(int idZawodnika) throws SQLException {
        String sql = "DELETE FROM Zawodnik WHERE idZawodnika=?";
        parserSQL.parseQuery(sql, idZawodnika).executeUpdate();
    }
}
