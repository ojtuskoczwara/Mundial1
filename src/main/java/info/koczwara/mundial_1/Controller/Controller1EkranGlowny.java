package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller1EkranGlowny {
    private EkranGlownyView view;

    public Controller1EkranGlowny(EkranGlownyView view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2PanelAdministratora(new PanelAdministratoraView());
            view.setVisible(false);
        }
    }
}
