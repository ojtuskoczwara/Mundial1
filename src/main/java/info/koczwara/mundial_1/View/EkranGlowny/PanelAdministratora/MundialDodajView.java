package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;

public class MundialDodajView extends JFrame {
    private JLabel nazwaMundialuLabel = new JLabel("Nazwa/Lokalizacja");
    private JTextField nazwaMundialuTextField = new JTextField();
    private JLabel rokMundialuLabel = new JLabel("Rok");
    private JTextField rokMundialuTextField = new JTextField();
    private JButton dodajMundialButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<<< Cofnij");

    public MundialDodajView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Mundial");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        nazwaMundialuLabel.setBounds(50,20,150,30);
        add(nazwaMundialuLabel);
        nazwaMundialuTextField.setBounds(50,50, 150, 30);
        add(nazwaMundialuTextField);
        rokMundialuLabel.setBounds(300,20,150,30);
        add(rokMundialuLabel);
        rokMundialuTextField.setBounds(300,50,50,30);
        add(rokMundialuTextField);
        dodajMundialButton.setBounds(250,200,100,50);
        add(dodajMundialButton);

        cofnijButton.setBounds(50,250,100,50);
        add(cofnijButton);
    }

    public String getNazwaMundialu() { return nazwaMundialuTextField.getText(); }

    public String getRokMundialu() { return rokMundialuTextField.getText().toString(); }

    public void setDodajMundialButtonListener(ActionListener listenDodajMundialButton) {
        dodajMundialButton.addActionListener(listenDodajMundialButton);
    }

    public void setCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

}
