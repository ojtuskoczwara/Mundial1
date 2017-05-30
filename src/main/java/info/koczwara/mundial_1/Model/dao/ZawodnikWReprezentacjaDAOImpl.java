package info.koczwara.mundial_1.Model.dao;

import info.koczwara.mundial_1.Model.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.Model.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikWReprezentacjaDAOImpl implements ZawodnikWReprezentacjaDAO {
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public List<Mundial> getAllMundiale() throws Exception {
        return null;
    }

    @Override
    public void addMundial(Mundial mundial) throws Exception {

    }

    @Override
    public List<Reprezentacja> getAllRepAtMundial(String mundialValue) throws Exception {
        List<Reprezentacja> reprezentacje = new ArrayList<>();
        String sql = "SELECT r.nazwa FROM Reprezentacja r, Mundial m, Zawodnik_W_Reprezentacja zwr" +
                " WHERE r.idReprezentacji = zwr.idReprezentacji AND m.idMundialu = zwr.idMundialu" +
                " AND m.lokalizacja = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialValue).executeQuery();
        while (resultSet.next()) {
            Reprezentacja r = new Reprezentacja();
            r.setNazwa(resultSet.getString("nazwa"));
            reprezentacje.add(r);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacje;
    }

    @Override
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception {

    }

    @Override
    public List<Zawodnik> getAllZawodnicyAtMundialInRep(String mundialValueFromJList, String repValueFromJList) throws Exception {
        List<Zawodnik> zawodnikList = new ArrayList<>();
        String sql = "SELECT z.imie, z.nazwisko FROM Zawodnik z, Mundial m, Reprezentacja r, Zawodnik_W_Reprezentacja zwr" +
                " WHERE r.idReprezentacji = zwr.idReprezentacji AND m.idMundialu = zwr.idMundialu AND z.idZawodnika = zwr.idZawodnika" +
                " AND m.lokalizacja = ? AND r.nazwa = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialValueFromJList, repValueFromJList).executeQuery();
        while (resultSet.next()) {
            Zawodnik z = new Zawodnik();
            z.setImie(resultSet.getString("imie"));
            z.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(z);
        }
        return zawodnikList;
    }

    @Override
    public void addZawodnik(Zawodnik zawodnik) throws Exception {

    }

    @Override
    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception {
        String sql = "INSERT INTO Zawodnik_W_Reprezentacja VALUES(?,?,?)";
        parserSQL.parseQuery(sql,idZawodnika, idReprezentacji, idMundialu).executeUpdate();
    }
}
