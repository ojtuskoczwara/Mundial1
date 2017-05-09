package info.koczwara.mundial_1.Controller;

import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.DAOImplementation.ZawodnikDAOImpl;
import info.koczwara.mundial_1.Model.Zawodnik;
import info.koczwara.mundial_1.View.ZawodnikView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;



public class Controller {

    private ZawodnikView view;
    private Zawodnik model;
    private ZawodnikDAO zawodnikDAO;

    public Controller(ZawodnikView view, Zawodnik model) {
        this.view = view;
        this.model = model;

        this.view.addDodajZawodnikaButtonListener(new DodajZawodnikaListener());
    }

    private class DodajZawodnikaListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           // String imie;
            //String nazwisko;

            try {
               // imie = view.getImie();
               // nazwisko = view.getNazwisko();
               // model.setImie(imie);
               // model.setNazwisko(nazwisko);
                model.setImie(view.getImie());
                model.setNazwisko(view.getNazwisko());
                zawodnikDAO = new ZawodnikDAOImpl();
                zawodnikDAO.addZawodnik(model);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
