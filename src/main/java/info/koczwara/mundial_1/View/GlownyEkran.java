/*
 * Created by JFormDesigner on Thu May 04 14:58:40 CEST 2017
 */

package info.koczwara.mundial_1.View;

import java.awt.event.*;
import org.jdesktop.layout.GroupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Wojciech Koczwara
 */
public class GlownyEkran extends JFrame {
    public GlownyEkran() {
        initComponents();
    }

    private void zawodnicyButtonActionPerformed(ActionEvent e) {
        ZawodnikWidok zawodnikWidok = new ZawodnikWidok();
        zawodnikWidok.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
        label1 = new JLabel();
        zawodnicyButton = new JButton();

        //======== this ========
        setTitle("Mundial pi\u0142karski");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Mistrzostwa \u015awiata");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- zawodnicyButton ----
        zawodnicyButton.setText("Zawodnicy");
        zawodnicyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zawodnicyButtonActionPerformed(e);
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
                            .add(zawodnicyButton)
                            .add(0, 284, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(label1)
                    .add(29, 29, 29)
                    .add(zawodnicyButton)
                    .addContainerGap(181, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Wojciech Koczwara
    private JLabel label1;
    private JButton zawodnicyButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
