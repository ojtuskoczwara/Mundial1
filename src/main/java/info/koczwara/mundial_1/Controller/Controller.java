package info.koczwara.mundial_1.Controller;

import info.koczwara.mundial_1.Model.dao.ZawodnikDAO;
import info.koczwara.mundial_1.Model.dao.ZawodnikDAOImpl;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
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
                if (view.getImie().isEmpty() || view.getNazwisko().isEmpty()) {
                    view.displayErrorMessage("Wypełnij wszystkie pola.");
                } else if (view.getImie().length() < 3 || view.getNazwisko().length() < 3) {
                    view.displayErrorMessage("Imię i nazwisko jest zbyt krótkie (minimum 3 znaki).");
                } else {
                    model.setImie(view.getImie());
                    model.setNazwisko(view.getNazwisko());
                    zawodnikDAO = new ZawodnikDAOImpl();
                    zawodnikDAO.addZawodnik(model);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
