package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.View.GlownyEkran;

import javax.swing.*;

public class Controller {

    public void startApp() {
        GlownyEkran glownyEkran = new GlownyEkran();
        glownyEkran.setLocationRelativeTo(null);
        glownyEkran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glownyEkran.setVisible(true);
    }
}
