package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEkranGlowny {
    private EkranGlownyView ekranGlownyView;

    public ControllerEkranGlowny(EkranGlownyView ekranGlownyView) {
        this.ekranGlownyView = ekranGlownyView;
        this.ekranGlownyView.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PanelAdministratoraView panelAdministratoraView = new PanelAdministratoraView();
            panelAdministratoraView.setLocationRelativeTo(null);
            panelAdministratoraView.setVisible(true);
            ekranGlownyView.setVisible(false);
        }
    }
}
