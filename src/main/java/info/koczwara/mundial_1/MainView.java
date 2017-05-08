package info.koczwara.mundial_1;

import info.koczwara.mundial_1.View.ClassB;
import info.koczwara.mundial_1.View.GlownyEkran;

import javax.swing.*;

public class MainView {
    public static void main(String[] args) {
        GlownyEkran glownyEkran = new GlownyEkran();
        glownyEkran.setLocationRelativeTo(null);
        glownyEkran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glownyEkran.setVisible(true);
    }


}
