package info.koczwara.mundial_1.Model.dao;


import info.koczwara.mundial_1.Model.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.utils.ParserSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MundialDAOImpl implements MundialDAO{

    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addMundial(Mundial mundial) throws Exception {
        String sql = "INSERT INTO Mundial(lokalizacja,rok) VALUES(?,?)";
        parserSQL.parseQuery(sql, mundial.getLokalizacja(), mundial.getRok()).executeUpdate();
    }

    @Override
    public List<Mundial> getAllMundial() throws Exception {
        List<Mundial> mundiale = new ArrayList<Mundial>();
        String sql = "SELECT * FROM Mundial";
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Mundial mundial = new Mundial();
            mundial.setLokalizacja(resultSet.getString("lokalizacja"));
            mundial.setRok(resultSet.getInt("rok"));
            mundiale.add(mundial);
        }
        ConnectionDB.disconnect(resultSet);
        return mundiale;
    }

    @Override
    public Mundial getMundialByLokalizacja(String lokalizacja) throws Exception {
        String sql = "SELECT * FROM Mundial WHERE lokalizacja = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql,lokalizacja).executeQuery();
        Mundial m = null;
        while (resultSet.next()) {
            m = new Mundial();
            m.setIdMundialu(resultSet.getInt("idMundialu"));
        }
        ConnectionDB.disconnect(resultSet);
        return m;
    }

    @Override
    public int deleteMundialByIdMundialu(int idMundialu) throws SQLException {
        String sql = "DELETE FROM Mundial WHERE idMundialu = ?";
        int wynik = parserSQL.parseQuery(sql, idMundialu).executeUpdate();
        return wynik;
    }

    @Override
    public Mundial getMundialByLokalizacjaRok(String lokalizacja, int rok) throws Exception {
        String sql = "SELECT * FROM Mundial WHERE lokalizacja = ? AND rok = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql,lokalizacja, rok).executeQuery();
        Mundial m = null;
        while (resultSet.next()) {
            m = new Mundial();
            m.setIdMundialu(resultSet.getInt("idMundialu"));
        }
        ConnectionDB.disconnect(resultSet);
        return m;
    }

    @Override
    public int updateMundial(int idMundialu, String nowaLokalizacja, int nowyRok) throws SQLException {
        String sql = "UPDATE Mundial SET lokalizacja = ?, rok = ? WHERE idMundialu = ?";
        PreparedStatement ps= parserSQL.parseQuery(sql, nowaLokalizacja, nowyRok, idMundialu);
        int wynik = ps.executeUpdate();
        return wynik;
    }

    @Override
    public int getMundialByLokalRok(String lokalizacja, int rok) throws Exception {
        String sql = "SELECT idMundialu FROM Mundial WHERE lokalizacja = ? AND rok = ?";
        PreparedStatement ps = parserSQL.parseQuery(sql,lokalizacja, rok);
        ResultSet rs = ps.executeQuery();
        int id = rs.getInt("idMundialu");
        ConnectionDB.disconnect(rs);
        return id;
    }

}
