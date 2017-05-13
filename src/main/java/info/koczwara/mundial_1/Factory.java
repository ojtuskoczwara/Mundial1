package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.DAO.ZawodnikDAOImpl;
import info.koczwara.mundial_1.Model.Entity.Zawodnik;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wojtek on 2017-04-26.
 */
public class Factory {

    public void dodawanieZawodnika() throws SQLException {
        Zawodnik z = new Zawodnik();
        ZawodnikDAOImpl zawodnikDAOImpl = new ZawodnikDAOImpl();
        z.setImie("Dawid");
        z.setNazwisko("Lala");
        zawodnikDAOImpl.addZawodnik(z);
    }

    public void wyswietlZawodnikaPoprzezId(int id) throws Exception {
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        Zawodnik z = dao.getZawodnikById(id);
        System.out.println("ID: " + z.getIdZawodnika());
        System.out.println("IMIĘ " + z.getImie());
        System.out.println("NAZWISKO: " + z.getNazwisko());
    }

    public void wyswietlZawodnikowPoprzezImieNazwisko(String imie, String nazwisko) throws Exception {
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        List<Zawodnik> zawodnicy = dao.getZawodnicyByImieNazwisko(imie, nazwisko);
        for (Zawodnik z: zawodnicy) {
            System.out.println(z.getImie() +" "+ z.getNazwisko() + " id: " + z.getIdZawodnika());
        }
    }

    public void wyswietlWszystkichZawodnikow() throws Exception {
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        List<Zawodnik> zawodnicy = dao.getAllZawodnik();
        for (Zawodnik z: zawodnicy) {
            System.out.println(z.getImie() +" "+ z.getNazwisko());
        }
    }

    public void usuwanieZawodnikaId(int id) throws Exception{
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        dao.deleteZawodnik(id);
    }
}
