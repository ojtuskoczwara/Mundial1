/*
 * Created by JFormDesigner on Thu May 04 15:03:51 CEST 2017
 */

package info.koczwara.mundial_1.View;

import java.awt.event.*;


import info.koczwara.mundial_1.Factory2;
import info.koczwara.mundial_1.Model.DAO.ZawodnikDAO;
import info.koczwara.mundial_1.Model.DAOImplementation.ZawodnikDAOImpl;
import info.koczwara.mundial_1.Model.Zawodnik;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author Wojciech Koczwara
 */
public class DodajZawodnikaWidok extends JFrame {
    public DodajZawodnikaWidok() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        ZawodnikWidok zawodnikWidok = new ZawodnikWidok();
        zawodnikWidok.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void dodajZawodnikaButtonActionPerformed(ActionEvent e) throws SQLException {
        if (imieTextField.getText().equals("") || nazwiskoTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Wszystkie pola muszą zostać wypełnione", "Błąd wypełniania", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Factory2 factory2 = new Factory2();
            factory2.dodawanieZawodnika(imieTextField.getText(),nazwiskoTextField.getText());
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
        label1 = new JLabel();
        imieLabel = new JLabel();
        nazwiskoLabel = new JLabel();
        imieTextField = new JTextField();
        nazwiskoTextField = new JTextField();
        dodajZawodnikaButton = new JButton();
        CofnijButton = new JButton();

        //======== this ========
        setTitle("Dodawanie zawodnika");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Dodawanie zawodnika");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- imieLabel ----
        imieLabel.setText("Imi\u0119:");

        //---- nazwiskoLabel ----
        nazwiskoLabel.setText("Nazwisko:");

        //---- dodajZawodnikaButton ----
        dodajZawodnikaButton.setText("Dodaj");
        dodajZawodnikaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dodajZawodnikaButtonActionPerformed(e);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //---- CofnijButton ----
        CofnijButton.setText("Cofnij");
        CofnijButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(imieLabel)
                            .addPreferredGap(LayoutStyle.RELATED, 55, Short.MAX_VALUE)
                            .add(imieTextField, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                        .add(label1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(CofnijButton)
                            .add(0, 0, Short.MAX_VALUE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(nazwiskoLabel)
                            .addPreferredGap(LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                            .add(nazwiskoTextField, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
                .add(contentPaneLayout.createSequentialGroup()
                    .add(133, 133, 133)
                    .add(dodajZawodnikaButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                    .add(0, 136, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(CofnijButton)
                    .addPreferredGap(LayoutStyle.RELATED, 20, Short.MAX_VALUE)
                    .add(label1)
                    .add(32, 32, 32)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(imieLabel)
                        .add(imieTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .add(18, 18, 18)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(nazwiskoLabel)
                        .add(nazwiskoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .add(18, 18, 18)
                    .add(dodajZawodnikaButton)
                    .add(48, 48, 48))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
    private JLabel label1;
    private JLabel imieLabel;
    private JLabel nazwiskoLabel;
    private JTextField imieTextField;
    private JTextField nazwiskoTextField;
    private JButton dodajZawodnikaButton;
    private JButton CofnijButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
