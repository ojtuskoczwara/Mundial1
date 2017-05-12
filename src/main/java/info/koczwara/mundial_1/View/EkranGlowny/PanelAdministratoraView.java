package info.koczwara.mundial_1.View.EkranGlowny;


import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelAdministratoraView extends JFrame {
    private JLabel mundialLabel = new JLabel("Mundial");
    private JButton dodajMundialButton = new JButton("Dodaj mundial");
    private JButton edytujMundialButton = new JButton("Edytuj mundial");
    private JLabel reprezentacjalLabel = new JLabel("Reprezentacje:");
    private JButton dodajReprezentacjaButton = new JButton("Dodaj reprezentacje");
    private JButton edytujReprezentacjaButton = new JButton("Edytuj reprezentacje");
    private JButton cofnijButton = new JButton("<<< Cofnij");

    public PanelAdministratoraView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Panel administratora");
        setLayout(null);

        mundialLabel.setBounds(10,10,500,50);
        add(mundialLabel);
        dodajMundialButton.setBounds(50,50,150,50);
        add(dodajMundialButton);
        edytujMundialButton.setBounds(250,50,150,50);
        add(edytujMundialButton);

        reprezentacjalLabel.setBounds(10,100,500,50);
        add(reprezentacjalLabel);
        dodajReprezentacjaButton.setBounds(50,140,150,50);
        add(dodajReprezentacjaButton);
        edytujReprezentacjaButton.setBounds(250,140,150,50);
        add(edytujReprezentacjaButton);

        cofnijButton.setBounds(10,300,100,30);
        add(cofnijButton);

        setVisible(true);

    }

    public void addDodajMundialButtonListener(ActionListener listenDodajMundialButton) {
        dodajMundialButton.addActionListener(listenDodajMundialButton);
    }

    public void addEdytujMundialButtonListener(ActionListener listenEdytujMundialButton) {
        edytujMundialButton.addActionListener(listenEdytujMundialButton);
    }

    public void addDodajReprezentacjaButtonListener(ActionListener listenDodajReprezentacjaButton) {
        dodajReprezentacjaButton.addActionListener(listenDodajReprezentacjaButton);
    }

    public void addEdytujReprezentacjaButtonListener(ActionListener listenEdytujReprezentacjaButton) {
        edytujReprezentacjaButton.addActionListener(listenEdytujReprezentacjaButton);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }
}
