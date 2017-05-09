package info.koczwara.mundial_1.View;


import javax.swing.*;

public class EkranGlownyView extends JFrame {

    private JButton mundialeButton = new JButton("Mundiale");
    private JButton zawodnicyButton = new JButton("Zawodnicy");
    private JButton wynikiButton = new JButton("Wyniki");
    private JButton panelAdministratoraButton = new JButton("Panel Administratora");

    public EkranGlownyView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Ekran główny");
        setLayout(null);

        mundialeButton.setBounds(250,30,100,50);
        add(mundialeButton);
        zawodnicyButton.setBounds(250,90,100,50);
        add(zawodnicyButton);
        wynikiButton.setBounds(250,150,100,50);
        add(wynikiButton);
        panelAdministratoraButton.setBounds(400,400,170,30);
        add(panelAdministratoraButton);


    }
}
