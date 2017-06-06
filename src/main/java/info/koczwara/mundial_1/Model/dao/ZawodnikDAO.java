package info.koczwara.mundial_1.Model.dao;


import info.koczwara.mundial_1.Model.entity.Zawodnik;

import java.sql.SQLException;
import java.util.List;

public interface ZawodnikDAO {

    public void addZawodnik(Zawodnik zawodnik) throws SQLException;
    public Zawodnik getZawodnikById(int id) throws Exception;
    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception;
    public List<Zawodnik> getAllZawodnik() throws Exception;
    public void updateZawodnik(Zawodnik zawodnik) throws SQLException;
    public void deleteZawodnik(int idZawodnika) throws SQLException;
    public  Zawodnik getLastZawodnik() throws Exception;
    public void updateZawodnikById(String imie, String nazwisko, Zawodnik zawodnik) throws Exception;
}
