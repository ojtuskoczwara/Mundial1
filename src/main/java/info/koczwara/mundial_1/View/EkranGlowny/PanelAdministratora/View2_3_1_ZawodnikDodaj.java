package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.*;


public class View2_3_1_ZawodnikDodaj extends JFrame {
    private JLabel imieLabel = new JLabel("Imię zawodnika:");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko zawodnika:");
    private JTextField imieTextField = new JTextField(10);
    private JTextField nazwiskoTextField = new JTextField(10);
    private JButton dodajButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<<< Cofnij");

    public View2_3_1_ZawodnikDodaj() {
        super("Dodaj zawodnika");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
