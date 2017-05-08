package info.koczwara.mundial_1.View;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassB extends JFrame implements ActionListener {

    public ClassB() {
        setSize(300,300);
        setTitle("Okno B");
        setLayout(null);
        JButton button = new JButton("Otwórz okno A");
        button.setBounds(100,50,150,50);
        add(button);
        button.addActionListener(this);

    }


    public void actionPerformed(ActionEvent e) {
        ClassA a = new ClassA();
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
}
