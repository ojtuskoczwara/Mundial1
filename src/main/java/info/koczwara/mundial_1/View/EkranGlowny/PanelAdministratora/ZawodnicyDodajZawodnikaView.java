package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.*;


public class ZawodnicyDodajZawodnikaView extends JFrame {
    private JLabel imieLabel = new JLabel("Imię zawodnika:");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko zawodnika:");
    private JTextField imieTextField = new JTextField(10);
    private JTextField nazwiskoTextField = new JTextField(10);
    private JButton dodajButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<<< Cofnij");

    public ZawodnicyDodajZawodnikaView() {
        super("Dodaj zawodnika");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        add(imieLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(imieTextField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(nazwiskoLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(nazwiskoTextField, gc);

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        new ZawodnicyDodajZawodnikaView();
    }
}
