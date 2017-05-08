/*
 * Created by JFormDesigner on Thu May 04 15:01:54 CEST 2017
 */

package info.koczwara.mundial_1.View;

import java.awt.event.*;
import org.jdesktop.layout.GroupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Wojciech Koczwara
 */
public class ZawodnikWidok extends JFrame {
    public ZawodnikWidok() {
        initComponents();
    }

    private void cofnijButtonActionPerformed(ActionEvent e) {
        GlownyEkran glownyEkran = new GlownyEkran();
        glownyEkran.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void dodajZawodnikaButtonActionPerformed(ActionEvent e) {
        DodajZawodnikaWidok dodajZawodnikaWidok = new DodajZawodnikaWidok();
        dodajZawodnikaWidok.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
        label1 = new JLabel();
        dodajZawodnikaButton = new JButton();
        wyswietlZawodnikaButton = new JButton();
        cofnijButton = new JButton();

        //======== this ========
        setTitle("Zawodnicy");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Zawodnicy");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- dodajZawodnikaButton ----
        dodajZawodnikaButton.setText("Dodaj zawodnika");
        dodajZawodnikaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dodajZawodnikaButtonActionPerformed(e);
            }
        });

        //---- wyswietlZawodnikaButton ----
        wyswietlZawodnikaButton.setText("Wy\u015bwietl zawodnika");

        //---- cofnijButton ----
        cofnijButton.setText("Cofnij");
        cofnijButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cofnijButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(label1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(wyswietlZawodnikaButton)
                                .add(dodajZawodnikaButton))
                            .add(0, 236, Short.MAX_VALUE)))
                    .addContainerGap())
                .add(contentPaneLayout.createSequentialGroup()
                    .add(cofnijButton)
                    .add(0, 322, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(cofnijButton)
                    .add(24, 24, 24)
                    .add(label1)
                    .add(18, 18, 18)
                    .add(dodajZawodnikaButton)
                    .add(18, 18, 18)
                    .add(wyswietlZawodnikaButton)
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
    private JLabel label1;
    private JButton dodajZawodnikaButton;
    private JButton wyswietlZawodnikaButton;
    private JButton cofnijButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
