package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_1_1_MundialDodaj;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_1_2_MundialEdytuj;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_1_3_MundialUsun;
import info.koczwara.mundial_1.View.View1_0_EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View2_0_PanelAdministratora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller2_0_PanelAdministratora {
    private View2_0_PanelAdministratora view;

    public Controller2_0_PanelAdministratora(View2_0_PanelAdministratora view) {
        this.view = view;
        this.view.addCofnijButtonListener(new CofnijDoEkranGlownyListener());
        this.view.addDodajMundialButtonListener(new DodajMundialListener());
        this.view.addDodajReprezentacjaButtonListener(new DodajReprezentacjeListener());
        this.view.addUsunMundialButtonListener(new UsunMundialListener());
        this.view.addEdytujMundialButtonListener(new EdytujMundialListener());
    }

    private class CofnijDoEkranGlownyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller1_0_EkranGlowny(new View1_0_EkranGlowny());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class DodajMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2_1_1_MundialDodaj(new View2_1_1_MundialDodaj(), new Mundial());
            view.setVisible(false);
        }
    }

    private class DodajReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class UsunMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2_1_3_MundialUsun(new View2_1_3_MundialUsun(), new Mundial());
            view.setVisible(false);
        }
    }

    private class EdytujMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2_1_2_MundialEdytuj(new View2_1_2_MundialEdytuj(), new Mundial());
            view.setVisible(false);
        }
    }
}
