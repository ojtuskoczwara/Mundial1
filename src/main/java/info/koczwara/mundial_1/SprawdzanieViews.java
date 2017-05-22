package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller1_0_EkranGlowny;
import info.koczwara.mundial_1.Model.DAO.MundialDAO;
import info.koczwara.mundial_1.Model.DAO.MundialDAOImpl;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_1_1_MundialDodaj;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_2_1_ReprezentacjaDodaj;
import info.koczwara.mundial_1.View.View1_0_EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View2_0_PanelAdministratora;
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
        View1_0_EkranGlowny startView = new View1_0_EkranGlowny();
        Controller1_0_EkranGlowny controller = new Controller1_0_EkranGlowny(startView);
        startView.setVisible(true);
    }

    public static void view2a_panelAdministratora(){
        View2_0_PanelAdministratora panelAdministratoraView = new View2_0_PanelAdministratora();
        panelAdministratoraView.setLocationRelativeTo(null);
        panelAdministratoraView.setVisible(true);
    }

    public static void view2a1_mundialDodaj() {
        View2_1_1_MundialDodaj view211MundialDodaj = new View2_1_1_MundialDodaj();
        view211MundialDodaj.setLocationRelativeTo(null);
        view211MundialDodaj.setVisible(true);
    }

    public static void view2a2_reprezentacjaDodaj() {
        View2_2_1_ReprezentacjaDodaj view = new View2_2_1_ReprezentacjaDodaj();
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
