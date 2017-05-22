package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.View1_0_EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View2_0_PanelAdministratora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller1_0_EkranGlowny {
    private View1_0_EkranGlowny view;

    public Controller1_0_EkranGlowny(View1_0_EkranGlowny view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2_0_PanelAdministratora(new View2_0_PanelAdministratora());
            view.setVisible(false);
        }
    }
}
