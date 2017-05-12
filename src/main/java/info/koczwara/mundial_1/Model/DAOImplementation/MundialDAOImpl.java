package info.koczwara.mundial_1.Model.DAOImplementation;


import info.koczwara.mundial_1.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.DAO.MundialDAO;
import info.koczwara.mundial_1.Model.Mundial;
import info.koczwara.mundial_1.utils.ParserSQL;

import java.sql.ResultSet;
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
}
