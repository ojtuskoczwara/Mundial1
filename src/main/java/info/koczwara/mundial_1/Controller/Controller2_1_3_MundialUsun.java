package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.DAO.MundialDAO;
import info.koczwara.mundial_1.Model.DAO.MundialDAOImpl;
import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.View2_1_3_MundialUsun;
import info.koczwara.mundial_1.View.EkranGlowny.View2_0_PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Controller2_1_3_MundialUsun {
    private View2_1_3_MundialUsun view;
    private Mundial model;
    private DefaultListModel dlm = new DefaultListModel();
    MundialDAO mundialDAO = new MundialDAOImpl();
    private String valueMundial;
    private String valueMundialLokalizacja;
    private int valueMundialRok;

    public Controller2_1_3_MundialUsun(View2_1_3_MundialUsun view, Mundial model) {
        this.view = view;
        this.model = model;

        setDLM();
        this.view.setCofnijButtonListener(new CofnijButtonListener());
        this.view.setUsunButtonListener(new UsunMundialButtonListener());
        this.view.setMundialeListMouseListener(new MundialeListMouseListener());
    }

    public void setDLM() {
        // Wstrzyknięcie danych do modeluMundialu który później jest argumentem JListMundiale
        dlm.removeAllElements();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m : mundialList) {
                String valueLokalizacjaRok = m.getLokalizacja() + " " + m.getRok();
                dlm.addElement(valueLokalizacjaRok);
            }
            this.view.setListMundialeModel(dlm); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class CofnijButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Controller2_0_PanelAdministratora(new View2_0_PanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class UsunMundialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Mundial m = null;
            int wynik = 0;
            try {
                m = mundialDAO.getMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
                int idMundialu = m.getIdMundialu();
                wynik = mundialDAO.deleteMundialByIdMundialu(idMundialu);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if (wynik > 0) {
                view.setInfoLabelText("Usunięcie mundialu zakończone powodzeniem!");
                view.setLokalizacjaTF("");
                view.setRokTF(null);
            }
            else
                view.setInfoLabelText("Operacja usunięcia mundialu nie powiodła się.");
            setDLM();
//            // ALBO zrobić to bez pobierania danych z DB a działanie na samej liście
//            dlm.removeElement(view.getMundialListSelectedValue().getSelectedValue());
//            view.setListMundialeModel(dlm);

        }
    }

    private class MundialeListMouseListener extends MouseAdapter { // element z JList jest pobierany i uzyty w DAOMundial
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialListSelectedValue().isSelectionEmpty()){ //jezeli element z listy JList jest wybrany/zaznaczony
                valueMundial = view.getMundialListSelectedValue().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0,valueMundial.length()-5); // toString do MundialLokalizacja
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length()-4)); // parseInt do MundialRok

                view.setLokalizacjaTF(valueMundialLokalizacja);
                view.setRokTF(String.valueOf(valueMundialRok));
            }
        }
    }
}
