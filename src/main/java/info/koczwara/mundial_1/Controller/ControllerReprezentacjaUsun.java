package info.koczwara.mundial_1.Controller;

import info.koczwara.mundial_1.Model.dao.ReprezentacjaDAO;
import info.koczwara.mundial_1.Model.dao.ReprezentacjaDAOImpl;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.utils.ShowMyMessage;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewReprezentacjaUsun;
import info.koczwara.mundial_1.View.EkranGlowny.View20PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Wojtek on 2017-05-29.
 */
public class ControllerReprezentacjaUsun {
    private ViewReprezentacjaUsun view;
    private Reprezentacja model;
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    ShowMyMessage showMyMessage = new ShowMyMessage();

    public ControllerReprezentacjaUsun(ViewReprezentacjaUsun view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.addUsunReprezentacjeButtonListener(new UsunReprezentacjaButton());
    }

    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller20PanelAdministratora(new View20PanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
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

    private class UsunReprezentacjaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getReprezentacjaList().isSelectionEmpty()) {
                view.addShowNazwaReprezentacjiTextField((String) view.getReprezentacjaList().getSelectedValue());
                int idReprezentacja = 0;
                try {
                    model = reprezentacjaDAO.getIdRepByNazwa(view.getReprezentacjaList().getSelectedValue().toString());
                    idReprezentacja = model.getIdReprezentacji();
                    reprezentacjaDAO.deleteReprezentacja(idReprezentacja);
                    setRepDLM();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else
                showMyMessage.showInfoJOptionPane("Nie wybrałeś żadnej reprezentacji z listy!", "Błąd", "Error");
        }
    }
}
