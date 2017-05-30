package info.koczwara.mundial_1.Controller;

import info.koczwara.mundial_1.Model.dao.ReprezentacjaDAO;
import info.koczwara.mundial_1.Model.dao.ReprezentacjaDAOImpl;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.utils.*;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewReprezentacjaDodaj;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerReprezentacjaDodaj {
    private ViewReprezentacjaDodaj view;
    private Reprezentacja model;
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    ShowMyMessage showMyMessage = new ShowMyMessage();


    public ControllerReprezentacjaDodaj(ViewReprezentacjaDodaj view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addDodajReprezentacjeButtonListener(new DodajReprezentacjaButton());
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());

    }


    public void setRepDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        dlm.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList) {
                dlm.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(dlm); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private class DodajReprezentacjaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setNazwa(view.getNazwaReprezentacji());
            try {
                reprezentacjaDAO.addReprezentacja(model);
                setRepDLM();
            } catch (Exception e1) {
                e1.printStackTrace();
                /*
                //zmienic w tabeli t_reprezentacja nazweRep na UNIQE
                showMyMessage.showInfoJOptionPane("Reprezentacja istnieje już w bazie danych!", "Błąd", "Error");
                */
            }


        }
    }

    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller20PanelAdministratora(new View20PanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }
}
