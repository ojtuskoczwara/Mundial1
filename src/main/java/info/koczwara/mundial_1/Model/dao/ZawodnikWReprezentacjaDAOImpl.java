package info.koczwara.mundial_1.Model.dao;

import info.koczwara.mundial_1.Model.Connection.ConnectionDB;
import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.Model.utils.ParserSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikWReprezentacjaDAOImpl implements ZawodnikWReprezentacjaDAO {
    private ParserSQL parserSQL = new ParserSQL();

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
    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception {
        String sql = "INSERT INTO Zawodnik_W_Reprezentacja VALUES(?,?,?)";
        parserSQL.parseQuery(sql,idZawodnika, idReprezentacji, idMundialu).executeUpdate();
    }

    @Override
    public List<Reprezentacja> getAllReprezentacjeAtMundial(String mundialName, int mundialRok) throws Exception {
        List<Reprezentacja> reprezentacjaList = new ArrayList<>();
        String sql = "SELECT distinct r.nazwa FROM Reprezentacja r, Mundial m, Zawodnik_W_Reprezentacja zwr" +
                " WHERE m.idMundialu = zwr.idMundialu AND r.idReprezentacji = zwr.idReprezentacji AND m.lokalizacja = ? AND m.rok = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialName, mundialRok).executeQuery();
        while (resultSet.next()) {
            Reprezentacja r = new Reprezentacja();
            r.setNazwa(resultSet.getString("nazwa"));
            reprezentacjaList.add(r);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaList;
    }

    @Override
    public int getIdZawodnikByLokalizacjaNazwaImieNazwisko(String lokalizacja, String nazwa, Zawodnik zawodnik) throws Exception {
        String sql = "SELECT z.idZawodnika FROM Zawodnik z, Reprezentacja r, Mundial m, Zawodnik_W_Reprezentacja zwr" +
                " WHERE m.idMundialu = zwr.idMundialu AND r.idReprezentacji = zwr.idReprezentacji AND z.idZawodnika = zwr.idZawodnika" +
                " AND m.lokalizacja = ? AND r.nazwa = ? AND z.imie = ? AND z.nazwisko = ?";
        PreparedStatement ps = parserSQL.parseQuery(sql, lokalizacja, nazwa, zawodnik.getImie(), zawodnik.getNazwisko());
        ResultSet resultSet = ps.executeQuery();
        int idZawodnika = resultSet.getInt("idZawodnika");
        ConnectionDB.disconnect(resultSet);
        return idZawodnika;
    }

    @Override
    public Zawodnik getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception {
        String sql = "SELECT * FROM Zawodnik z, Reprezentacja r, Mundial m, Zawodnik_W_Reprezentacja zwr" +
                " WHERE m.idMundialu = zwr.idMundialu AND r.idReprezentacji = zwr.idReprezentacji AND z.idZawodnika = zwr.idZawodnika" +
                " AND m.lokalizacja = ? AND m.rok = ? AND r.nazwa = ? AND z.imie = ? AND z.nazwisko = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getLokalizacja(), mundial.getRok(), reprezentacja.getNazwa(), zawodnik.getImie(), zawodnik.getNazwisko()).executeQuery();
        Zawodnik z = new Zawodnik();
        while (resultSet.next()){
            z.setIdZawodnika(resultSet.getInt("idZawodnika"));
            z.setImie(resultSet.getString("imie"));
            z.setNazwisko(resultSet.getString("nazwisko"));
        }
        ConnectionDB.disconnect(resultSet);
        return z;
    }

    @Override
    public void deleteRowsByMundialIdReprezentacjaIdZawodnikId(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception {
        String sql = "DELETE FROM Zawodnik_W_Reprezentacja WHERE idMundialu = ? AND idReprezentacji = ? AND idZawodnika = ?";
        parserSQL.parseQuery(sql, mundial.getIdMundialu(), reprezentacja.getIdReprezentacji(), zawodnik.getIdZawodnika()).executeUpdate();
    }
}
