package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.ControllerEkranGlowny;
import info.koczwara.mundial_1.Model.dao.MundialDAO;
import info.koczwara.mundial_1.Model.dao.MundialDAOImpl;
import info.koczwara.mundial_1.Model.dao.ZawodnikWReprezentacjaDAO;
import info.koczwara.mundial_1.Model.dao.ZawodnikWReprezentacjaDAOImpl;
import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewMundialDodaj;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View231ZawodnikDodajDoReprezentacjaWMundial;
import info.koczwara.mundial_1.View.ViewEkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.ViewPanelAdministratora;
import info.koczwara.mundial_1.View.ZawodnikView;

import java.sql.SQLException;

public class SprawdzanieViews {


    public static void main(String[] args) throws Exception {
        //view2a2_reprezentacjaDodaj();
        //zawodnik();
        //view2a_panelAdministratora();
        //view2a1_mundialDodaj();
        //deleteMundial(5);
        //updateMundial();

        Mundial mundial = new Mundial();
        mundial.setLokalizacja("Polska/Ukraina");
        mundial.setRok(2012);
        Reprezentacja reprezentacja = new Reprezentacja();
        reprezentacja.setNazwa("Polska");
        Zawodnik zawodnik = new Zawodnik();
        zawodnik.setImie("Jan");
        zawodnik.setNazwisko("Kowalski");

        ZawodnikWReprezentacjaDAO dao = new ZawodnikWReprezentacjaDAOImpl();
        Zawodnik zawodnik2 = new Zawodnik();
        zawodnik = dao.getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(mundial,reprezentacja,zawodnik);
        System.out.println("zawodnik Przed:  " +zawodnik.getIdZawodnika()+" "+zawodnik.getImie()+" "+zawodnik.getNazwisko());
        zawodnik.setIdZawodnika(zawodnik2.getIdZawodnika());
        System.out.println("zawodnik2 Po:  "+zawodnik2.getIdZawodnika());
        System.out.println("zawodnik Po:  " +zawodnik.getIdZawodnika());




    }

    public static void view1_ekranGlowny() {
        ViewEkranGlowny startView = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(startView);
        startView.setVisible(true);
    }

    public static void view2a_panelAdministratora(){
        ViewPanelAdministratora panelAdministratoraView = new ViewPanelAdministratora();
        panelAdministratoraView.setLocationRelativeTo(null);
        panelAdministratoraView.setVisible(true);
    }

    public static void view2a1_mundialDodaj() {
        ViewMundialDodaj viewMundialDodaj = new ViewMundialDodaj();
        viewMundialDodaj.setLocationRelativeTo(null);
        viewMundialDodaj.setVisible(true);
    }

    public static void view2a2_reprezentacjaDodaj() {
        View231ZawodnikDodajDoReprezentacjaWMundial view = new View231ZawodnikDodajDoReprezentacjaWMundial();
        view.setVisible(true);
    }

    public static void zawodnik() {
        ZawodnikView zawodnikView = new ZawodnikView();
        zawodnikView.setLocationRelativeTo(null);
        zawodnikView.setVisible(true);
    }

    public static void deleteMundial(int id) {
        MundialDAO dao = new MundialDAOImpl();
        int wynik = 0;
        try {
            wynik = dao.deleteMundialByIdMundialu(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (wynik>0)
            System.out.println("Usuwanie mundialu zakończone powodzeniem.");
        else{
            System.out.println("Usuwanie mundialu zakończone niepowodzeniem.");
        }

    }

    public static void updateMundial() {
        MundialDAO dao = new MundialDAOImpl();
        int wynik = 0;
        try {
            wynik = dao.updateMundial(1,"Brazylia", 2014);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (wynik>0)
            System.out.println("Update mundialu zakończone powodzeniem.");
        else{
            System.out.println("Update mundialu zakończone niepowodzeniem.");
        }
        System.out.println(wynik);
    }


}
