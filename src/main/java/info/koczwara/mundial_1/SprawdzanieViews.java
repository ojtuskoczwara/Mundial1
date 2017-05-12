package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller1EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.MundialDodajView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ReprezentacjaDodajView;
import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;
import info.koczwara.mundial_1.View.ZawodnikView;

public class SprawdzanieViews {


    public static void main(String[] args) {
        view2a2_reprezentacjaDodaj();

    }

    public static void view1_ekranGlowny() {
        EkranGlownyView startView = new EkranGlownyView();
        Controller1EkranGlowny controller = new Controller1EkranGlowny(startView);
        startView.setVisible(true);
    }

    public static void view2a_panelAdministratora(){
        PanelAdministratoraView panelAdministratoraView = new PanelAdministratoraView();
        panelAdministratoraView.setLocationRelativeTo(null);
        panelAdministratoraView.setVisible(true);
    }

    public static void view2a1_mundialDodaj() {
        MundialDodajView mundialDodajView = new MundialDodajView();
        mundialDodajView.setLocationRelativeTo(null);
        mundialDodajView.setVisible(true);
    }

    public static void view2a2_reprezentacjaDodaj() {
        ReprezentacjaDodajView view = new ReprezentacjaDodajView();
        view.setVisible(true);
    }

    public static void zawodnik() {
        ZawodnikView zawodnikView = new ZawodnikView();
        zawodnikView.setLocationRelativeTo(null);
        zawodnikView.setVisible(true);
    }

}
