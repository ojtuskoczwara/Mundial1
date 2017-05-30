package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller1EkranGlowny;
import info.koczwara.mundial_1.Model.dao.MundialDAO;
import info.koczwara.mundial_1.Model.dao.MundialDAOImpl;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewMundialDodaj;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View231ZawodnikDodajDoReprezentacjaWMundial;
import info.koczwara.mundial_1.View.View1EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;
import info.koczwara.mundial_1.View.ZawodnikView;

import java.sql.SQLException;

public class SprawdzanieViews {


    public static void main(String[] args) throws Exception {
        //view2a2_reprezentacjaDodaj();
        //zawodnik();
        //view2a_panelAdministratora();
        //view2a1_mundialDodaj();
        //deleteMundial(5);
        updateMundial();

    }

    public static void view1_ekranGlowny() {
        View1EkranGlowny startView = new View1EkranGlowny();
        Controller1EkranGlowny controller = new Controller1EkranGlowny(startView);
        startView.setVisible(true);
    }

    public static void view2a_panelAdministratora(){
        View20PanelAdministratora panelAdministratoraView = new View20PanelAdministratora();
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
