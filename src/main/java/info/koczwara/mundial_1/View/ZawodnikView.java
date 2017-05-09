package info.koczwara.mundial_1.View;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Wojtek on 2017-05-08.
 */
public class ZawodnikView extends JFrame{

    private JLabel imieLabel = new JLabel("Imie");
    private JTextField imieTextField = new JTextField(10);
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JTextField nazwiskoTextField = new JTextField(10);
    private JButton dodajZawodnikaButton = new JButton("Dodaj");

    public ZawodnikView() {
        JPanel zawodnikPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);

        zawodnikPanel.add(imieLabel);
        zawodnikPanel.add(imieTextField);
        zawodnikPanel.add(nazwiskoLabel);
        zawodnikPanel.add(nazwiskoTextField);
        zawodnikPanel.add(dodajZawodnikaButton);

        this.add(zawodnikPanel);
    }

    public String getImie() {
        return imieTextField.getText();
    }

    public String getNazwisko() {
        return nazwiskoTextField.getText();
    }

    public void addDodajZawodnikaButtonListener(ActionListener listenForDodajZawodnikaButton) {        dodajZawodnikaButton.addActionListener(listenForDodajZawodnikaButton);
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
