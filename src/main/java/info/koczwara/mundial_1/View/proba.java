package info.koczwara.mundial_1.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wojtek on 2017-05-15.
 */
public class proba extends JFrame {

    private JButton dodaj = new JButton("Dodaj mundial");
    private JButton edytuj = new JButton("Edytuj mundial");
    private JButton usun = new JButton("Usun mundial");

    public proba() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.setTitle("Panel administratora");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        JPanel mundialPanel = new JPanel();
        dodaj.setBounds(10,10,100,50);
        mundialPanel.add(dodaj);
        edytuj.setBounds(120,10,100,50);
        mundialPanel.add(edytuj);
        usun.setBounds(230,10,100,50);
        mundialPanel.add(usun);
        mundialPanel.setBounds(10,10,450,100);
        mundialPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Mundial Panel"));
        this.add(mundialPanel);

    }

    public static void main(String[] args) {
        new proba();
    }

}

