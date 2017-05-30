package info.koczwara.mundial_1.Model.dao;

import info.koczwara.mundial_1.Model.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReprezentacjaDAOImpl implements ReprezentacjaDAO {
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception {
        String sql = "INSERT INTO Reprezentacja(nazwa) VALUES(?)";
        parserSQL.parseQuery(sql,reprezentacja.getNazwa()).executeUpdate();
    }

    @Override
    public Reprezentacja getReprezentacjaById(int id) throws Exception {
        String sql = "SELECT * FROM Reprezentacja WHERE idReprezentacji = ?";
        Reprezentacja reprezentacja = null;
        ResultSet resultSet = parserSQL.parseQuery(sql, id).executeQuery();
        while (resultSet.next()) {
            reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa"));
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacja;
    }

    @Override
    public List<Reprezentacja> getAllReprezentacja() throws Exception {
        List<Reprezentacja> reprezentacje = new ArrayList<Reprezentacja>();
        String sql = "SELECT * FROM Reprezentacja";
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Reprezentacja reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa"));
            reprezentacje.add(reprezentacja);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacje;
    }

    @Override
    public void deleteReprezentacja(int id) throws Exception {
        String sql = "DELETE FROM Reprezentacja WHERE idReprezentacji = ?";
        parserSQL.parseQuery(sql, id).executeUpdate();
    }

    @Override
    public void updateReprezentacja(Reprezentacja reprezentacja) throws Exception {
        String sql = "UPDATE Reprezentacja SET nazwa = ? WHERE idReprezentacji = ?";
        parserSQL.parseQuery(sql,reprezentacja.getNazwa(), reprezentacja.getIdReprezentacji()).executeUpdate();
    }

    @Override
    public Reprezentacja getIdRepByNazwa(String nazwaRep) throws Exception {
        String sql = "SELECT * FROM Reprezentacja WHERE nazwa = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, nazwaRep).executeQuery();
        Reprezentacja reprezentacja = null;
        while (resultSet.next()) {
            reprezentacja = new Reprezentacja();
            reprezentacja.setIdReprezentacji(resultSet.getInt("idReprezentacji"));
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacja;
    }
}
