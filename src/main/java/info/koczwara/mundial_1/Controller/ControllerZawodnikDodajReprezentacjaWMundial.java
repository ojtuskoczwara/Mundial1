package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.dao.*;
import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.Model.entity.ZawodnikWReprezentacja;
import info.koczwara.mundial_1.Model.utils.ShowMyMessage;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewZawodnikDodajDoReprezentacjaWMundial;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerZawodnikDodajReprezentacjaWMundial {
    private ViewZawodnikDodajDoReprezentacjaWMundial view;
    private Zawodnik modelZawodnik;
    private Reprezentacja modelReprezentacja;
    private Mundial modelMundial;
    private ZawodnikWReprezentacja modelZawodnikWReprezentacja;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel reprezentacjaListModel = new DefaultListModel();
    private DefaultListModel zawodnikListModel = new DefaultListModel();
    ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    MundialDAO mundialDAO = new MundialDAOImpl();
    ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    ShowMyMessage showMyMessage = new ShowMyMessage();
    private String valueMundial, valueMundialLokalizacja, valueReprezentacjaNazwa;
    private int valueMundialRok;


    public ControllerZawodnikDodajReprezentacjaWMundial(ViewZawodnikDodajDoReprezentacjaWMundial view, Zawodnik modelZawodnik, Reprezentacja modelReprezentacja, Mundial modelMundial, ZawodnikWReprezentacja modelZawodnikWReprezentacja) {
        this.view = view;
        this.modelZawodnik = modelZawodnik;
        this.modelReprezentacja = modelReprezentacja;
        this.modelMundial = modelMundial;
        this.modelZawodnikWReprezentacja = modelZawodnikWReprezentacja;

        setMundialDLM();
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.addMundialListMouseListener(new WybranieElementuMundialList());
        this.view.addReprezentacjaListMouseListener(new WybranieElementuReprezentacjaList());
        this.view.addDodajZawodnikaButtonListener(new DodajZawodnikaButton());
    }


    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller20PanelAdministratora(new View20PanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }

    public void setMundialDLM() {
        // Wstrzyknięcie danych do modeluMundialu który później jest argumentem JListMundiale
        mundialListModel.removeAllElements();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m : mundialList) {
                String valueLokalizacjaRok = m.getLokalizacja() + " " + m.getRok();
                mundialListModel.addElement(valueLokalizacjaRok);
            }
            this.view.addListModelToMundialList(mundialListModel); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setReprezentacjaDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        reprezentacjaListModel.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList) {
                reprezentacjaListModel.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(reprezentacjaListModel); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Wyswietlenie listy reprezentacji oraz wyczyszczenie listy zawodnikow po kliknieciu na ktorykolwiek element listy mundial
    private class WybranieElementuMundialList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty())
                setReprezentacjaDLM();
            zawodnikListModel.removeAllElements();
        }
    }

//Wyswietlenie listy zawodnikow ktorzy sa na danym mundialu i w danej reprezentacji po kliknieciu na listy(mundial i reprezentacja)
    private class WybranieElementuReprezentacjaList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            zawodnikListModel.removeAllElements();
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length() - 5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length() - 4));
                valueReprezentacjaNazwa = view.getReprezentacjaList().getSelectedValue().toString();
                try {
                    List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getAllZawodnicyAtMundialInRep(valueMundialLokalizacja, valueReprezentacjaNazwa);
                    for (Zawodnik z : zawodnikList) {
                        String zaw = z.getImie() + " " + z.getNazwisko();
                        zawodnikListModel.addElement(zaw);
                    }
                    view.addListModelToZawodnikList(zawodnikListModel);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    private class DodajZawodnikaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getImieZawodnika().isEmpty() || view.getNazwiskoZawodnika().isEmpty()) {
                showMyMessage.errorMessage("Wypełnij pola IMIĘ i NAZWISKO!", "Uzupełnij brakujące pola");
            }
            else {
                //Dodanie zawodnika do tabeli Zawodnik
                modelZawodnik.setImie(view.getImieZawodnika());
                modelZawodnik.setNazwisko(view.getNazwiskoZawodnika());
                try {
                    zawodnikDAO.addZawodnik(modelZawodnik);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //Pobranie idMundialu z tabeli t_Mundial automatycznie po dodaniu nowego uzytkownika, idMundialu == zaznaczony element z JList mundialList
                try {
                    modelMundial = mundialDAO.getMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                //Pobranie idReprezentacji z tabeli t_Reprezentacja, idReprezentacja == zaznaczony element z JList reprezentacjaList
                try {
                    modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                //Pobranie idZawodnika z tabeli t_Zawodnik, idZawodnika == ostatni dodany zawodnik
                try {
                    modelZawodnik = zawodnikDAO.getLastZawodnik();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                //Dodanie zawodnika,reprezentacji,mundialu do tabeli t_Zawodnik_W_Reprezentacja
                try {
                    zawodnikWReprezentacjaDAO.addZawodnikRepMundial(modelZawodnik.getIdZawodnika(), modelReprezentacja.getIdReprezentacji(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                //Dodanie zawodnika do JList zawodnikListModel ale bez uzycia metody pobierajacej z DB danych
                //Po wybraniu innej reprezentacji lista wczyta juz z DB dane zawodnikow
                String zawodnikDodajDoJListBezBazyDanych = modelZawodnik.getImie() +" "+ modelZawodnik.getNazwisko();
                zawodnikListModel.addElement(zawodnikDodajDoJListBezBazyDanych);
            }
        }

    }
}
