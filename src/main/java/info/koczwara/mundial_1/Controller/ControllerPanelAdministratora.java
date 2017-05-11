package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.MundialDodajView;
import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPanelAdministratora {
    private PanelAdministratoraView panelAdministratoraView;

    public ControllerPanelAdministratora(PanelAdministratoraView panelAdministratoraView) {
        this.panelAdministratoraView = panelAdministratoraView;
        this.panelAdministratoraView.addCofnijButtonListener(new CofnijDoEkranGlownyListener());
        this.panelAdministratoraView.addDodajMundialButtonListener(new DodajMundialListener());
    }

    private class CofnijDoEkranGlownyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EkranGlownyView ekranGlownyView = new EkranGlownyView();
            ekranGlownyView.setLocationRelativeTo(null);
            ekranGlownyView.setVisible(true);
            panelAdministratoraView.setVisible(false);
            panelAdministratoraView.dispose();
        }
    }

    private class DodajMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MundialDodajView mundialDodajView = new MundialDodajView();
            mundialDodajView.setLocationRelativeTo(null);
            mundialDodajView.setVisible(true);
            panelAdministratoraView.setVisible(false);
        }
    }
}
