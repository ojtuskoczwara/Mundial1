package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;

public class ViewZawodnikUsun extends JFrame {
    private JButton usunButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList;
    private JList reprezentacjaList;
    private JList zawodnikList;
    private DefaultListModel zawodnikListModel;
    private DefaultListModel mundialListModel;
    private DefaultListModel reprezentacjaListModel;

    public ViewZawodnikUsun(){
        super("Edytuj zawodnika");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }

}
