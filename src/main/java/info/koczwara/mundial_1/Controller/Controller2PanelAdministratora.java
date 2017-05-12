package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.MundialDodajView;
import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller2PanelAdministratora {
    private PanelAdministratoraView view;

    public Controller2PanelAdministratora(PanelAdministratoraView view) {
        this.view = view;
        this.view.addCofnijButtonListener(new CofnijDoEkranGlownyListener());
        this.view.addDodajMundialButtonListener(new DodajMundialListener());
        this.view.addDodajReprezentacjaButtonListener(new DodajReprezentacjeListener());
    }

    private class CofnijDoEkranGlownyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller1EkranGlowny(new EkranGlownyView());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class DodajMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller21MundialDodaj(new MundialDodajView(), new Mundial());
            view.setVisible(false);
        }
    }

    private class DodajReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
