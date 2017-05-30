package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;

public class View232ZawodnikEdytujReprezentacjaWMundial extends JFrame{
    private JLabel imieLabel = new JLabel("Imię:");
    private JTextField imieTextField = new JTextField();
    private JLabel nazwiskoLabel = new JLabel("Nazwisko:");
    private JTextField nazwiskoTextField = new JTextField();
    private JButton dodajButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList;
    private JList reprezentacjaList;
    private JList zawodnikList;
    private DefaultListModel zawodnikListModel;
    private DefaultListModel mundialListModel;
    private DefaultListModel reprezentacjaListModel;

    public View232ZawodnikEdytujReprezentacjaWMundial() {
        super("Dodawanie reprezentacji");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        mundialListModel = new DefaultListModel();
        mundialList= new JList();
        mundialList.setBounds(50,20,120,200);
        add(mundialList);

        reprezentacjaListModel = new DefaultListModel();
        reprezentacjaList = new JList();
        reprezentacjaList.setBounds(200,20,120,200);
        add(reprezentacjaList);

        zawodnikListModel = new DefaultListModel();
        zawodnikList = new JList();
        zawodnikList.setBounds(350,20,120,200);
        add(zawodnikList);

        imieLabel.setBounds(50,250,50,30);
        add(imieLabel);
        imieTextField.setBounds(90,250,150,30);
        add(imieTextField);
        nazwiskoLabel.setBounds(250,250,60,30);
        add(nazwiskoLabel);
        nazwiskoTextField.setBounds(320,250,150,30);
        add(nazwiskoTextField);
        dodajButton.setBounds(250,400,100,30);
        add(dodajButton);
        cofnijButton.setBounds(20,400,100,30);
        add(cofnijButton);
    }



}
