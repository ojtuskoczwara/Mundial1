package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;


public class ZawodnicyDodajZawodnikaView extends JFrame {
    private JLabel imieLabel, nazwiskoLabel;
    private JTextField imieTextField, nazwiskoTextField;
    private JButton dodajButton, cofnijButton;

    public ZawodnicyDodajZawodnikaView() {
        super("Dodaj zawodnika");

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){

    }
}
