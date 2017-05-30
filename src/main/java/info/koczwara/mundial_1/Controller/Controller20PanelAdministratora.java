package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.Model.entity.ZawodnikWReprezentacja;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.*;
import info.koczwara.mundial_1.View.View1EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller20PanelAdministratora {
    private View20PanelAdministratora view;

    public Controller20PanelAdministratora(View20PanelAdministratora view) {
        this.view = view;
        this.view.addCofnijButtonListener(new CofnijDoEkranGlownyListener());
        this.view.addDodajMundialButtonListener(new DodajMundialListener());
        this.view.addEdytujMundialButtonListener(new EdytujMundialListener());
        this.view.addUsunMundialButtonListener(new UsunMundialListener());
        this.view.addDodajReprezentacjaButtonListener(new DodajReprezentacjeListener());
        this.view.addEdytujReprezentacjaButtonListener(new EdytujReprezentacjeListener());
        this.view.addUsunReprezentacjaButtonListener(new UsunReprezentacjeListener());
        this.view.addDodajZawodnikButtonListener(new DodajZawodnikListener());


    }

    private class CofnijDoEkranGlownyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller1EkranGlowny(new View1EkranGlowny());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class DodajMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialDodaj(new ViewMundialDodaj(), new Mundial());
            view.setVisible(false);
        }
    }

    private class EdytujMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialEdytuj(new ViewMundialEdytuj(), new Mundial());
            view.setVisible(false);
        }
    }

    private class UsunMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialUsun(new ViewMundialUsun(), new Mundial());
            view.setVisible(false);
        }
    }

    private class DodajReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaDodaj(new ViewReprezentacjaDodaj(), new Reprezentacja());
            view.setVisible(false);

        }
    }

    private class EdytujReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaEdytuj(new ViewReprezentacjaEdytuj(), new Reprezentacja());
            view.setVisible(false);
        }
    }

    private class UsunReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaUsun(new ViewReprezentacjaUsun(), new Reprezentacja());
            view.setVisible(false);
        }
    }


    private class DodajZawodnikListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnikDodajReprezentacjaWMundial(new ViewZawodnikDodajDoReprezentacjaWMundial(), new Zawodnik(), new Reprezentacja(), new Mundial(), new ZawodnikWReprezentacja());
            view.setVisible(false);
        }
    }
}
