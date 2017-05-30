package info.koczwara.mundial_1.Model.utils;

import javax.swing.*;

/**
 * Created by Wojtek on 2017-05-29.
 */
public  class ShowMyMessage {
    public void showInfoJOptionPane(String message, String title, String type) {
        if (type == "Error")
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        else if (type == "Information")
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        else if (type == "Warning")
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }


    public void errorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void informationMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void warningMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}
