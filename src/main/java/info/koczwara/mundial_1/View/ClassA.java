package info.koczwara.mundial_1.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClassA extends JFrame implements ActionListener{

    public ClassA() {
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        JButton button = new JButton("Cofnij do okno B");
        button.setBounds(100,50,150,50);
        add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ClassB b = new ClassB();
        b.setLocationRelativeTo(null);
        b.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
}
