package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.DAOImplementation.ZawodnikDAOImpl;
import info.koczwara.mundial_1.Model.Zawodnik;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws Exception {
        dodawanieZawodnika();
        //wyswietlZawodnikaPoprzezId(2);
        wyswietlZawodnikowPoprzezImieNazwisko("Adam", "Adamiak");
    }

    public static void dodawanieZawodnika() throws SQLException {
        Zawodnik z = new Zawodnik();
        ZawodnikDAOImpl zawodnikDAOImpl = new ZawodnikDAOImpl();
        z.setImie("Franek");
        z.setNazwisko("Frankowski");
        zawodnikDAOImpl.addZawodnik(z);
    }

    public static void wyswietlZawodnikaPoprzezId(int id) throws Exception {
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        Zawodnik z = dao.getZawodnikById(id);
        System.out.println("ID: " + z.getIdZawodnika());
        System.out.println("IMIĘ " + z.getImie());
        System.out.println("NAZWISKO: " + z.getNazwisko());
    }

    public static void wyswietlZawodnikowPoprzezImieNazwisko(String imie, String nazwisko) throws Exception {
        ZawodnikDAO dao = new ZawodnikDAOImpl();
        List<Zawodnik> zawodnicy = dao.getZawodnicyByImieNazwisko(imie, nazwisko);
        for (Zawodnik z: zawodnicy) {
            System.out.println(z.getImie());
        }
    }


}
