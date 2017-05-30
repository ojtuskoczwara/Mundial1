package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.View1EkranGlowny;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller1EkranGlowny {
    private View1EkranGlowny view;

    public Controller1EkranGlowny(View1EkranGlowny view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller20PanelAdministratora(new View20PanelAdministratora());
            view.setVisible(false);
        }
    }
}
