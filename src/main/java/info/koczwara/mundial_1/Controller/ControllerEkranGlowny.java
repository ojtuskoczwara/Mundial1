package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.ViewEkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.ViewPanelAdministratora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEkranGlowny {
    private ViewEkranGlowny view;

    public ControllerEkranGlowny(ViewEkranGlowny view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
        }
    }
}
