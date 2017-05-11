package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.ControllerEkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.MundialDodajView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ZawodnicyDodajZawodnikaView;
import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;
import info.koczwara.mundial_1.View.ZawodnikView;

public class SprawdzanieViews {


    public static void main(String[] args) {
        // panelAdministratora();
        //mundialDodaj();
        //zawodnik();

    }



    public static void panelAdministratora(){
        PanelAdministratoraView panelAdministratoraView = new PanelAdministratoraView();
        panelAdministratoraView.setLocationRelativeTo(null);
        panelAdministratoraView.setVisible(true);
    }

    public static void ekranGlowny() {
        EkranGlownyView startView = new EkranGlownyView();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(startView);
        startView.setVisible(true);
    }

    public static void ekranGlowny2() {
        EkranGlownyView ekranGlownyView = new EkranGlownyView();
        ekranGlownyView.setLocationRelativeTo(null);
        ekranGlownyView.setVisible(true);
    }

    public static void mundialDodaj() {
        MundialDodajView mundialDodajView = new MundialDodajView();
        mundialDodajView.setLocationRelativeTo(null);
        mundialDodajView.setVisible(true);
    }

    public static void zawodnik() {
        ZawodnikView zawodnikView = new ZawodnikView();
        zawodnikView.setLocationRelativeTo(null);
        zawodnikView.setVisible(true);
    }

}
