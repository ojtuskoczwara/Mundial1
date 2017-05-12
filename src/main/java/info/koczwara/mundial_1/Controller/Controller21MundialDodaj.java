package info.koczwara.mundial_1.Controller;

import info.koczwara.mundial_1.Model.DAO.MundialDAO;
import info.koczwara.mundial_1.Model.DAO.MundialDAOImpl;
import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.MundialDodajView;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratoraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller21MundialDodaj {
    private MundialDodajView view;
    private Mundial model;

    public Controller21MundialDodaj(MundialDodajView view, Mundial model) {
        this.view = view;
        this.model = model;
        this.view.setDodajMundialButtonListener(new DodajMundialButtonListener());
        this.view.setCofnijButtonListener(new CofnijButtonListener());
    }

    private class DodajMundialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.setLokalizacja(view.getNazwaMundialu());
                model.setRok(Integer.parseInt(view.getRokMundialu()));
                MundialDAO mundialDAO = new MundialDAOImpl();
                mundialDAO.addMundial(model);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }


    private class CofnijButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2PanelAdministratora(new PanelAdministratoraView());
            view.setVisible(false);
            view.dispose();
        }
    }
}
