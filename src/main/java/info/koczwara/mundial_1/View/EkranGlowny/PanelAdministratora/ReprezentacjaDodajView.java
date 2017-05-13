package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;

import info.koczwara.mundial_1.Model.DAO.*;
import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.Model.Entity.Reprezentacja;
import info.koczwara.mundial_1.Model.Entity.Zawodnik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ReprezentacjaDodajView extends JFrame implements ActionListener {
    private JLabel imieLabel = new JLabel("Imię:");
    private JTextField imieTextField = new JTextField();
    private JLabel nazwiskoLabel = new JLabel("Nazwisko:");
    private JTextField nazwiskoTextField = new JTextField();
    private JButton dodajButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList listaMundialiList;
    private JList listaReprezentacjiList;
    private JList listaZawodnikowList;
    private DefaultListModel modelZawodnik;



    public ReprezentacjaDodajView() {
        super("Dodawanie reprezentacji");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        DefaultListModel modelMundial = new DefaultListModel();
        listaMundialiList= new JList(modelMundial);
        listaMundialiList.setBounds(50,20,120,200);
        add(listaMundialiList);

        DefaultListModel modelRep = new DefaultListModel();
        listaReprezentacjiList = new JList(modelRep);
        listaReprezentacjiList.setBounds(200,20,120,200);
        add(listaReprezentacjiList);

        modelZawodnik = new DefaultListModel();
        listaZawodnikowList = new JList(modelZawodnik);
        listaZawodnikowList.setBounds(350,20,120,200);
        add(listaZawodnikowList);

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

        dodajButton.addActionListener(this);

        MundialDAO mundialDAO = new MundialDAOImpl();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m: mundialList) {
                modelMundial.addElement(m.getLokalizacja());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        ReprezentacjaDAO dao = new ReprezentacjaDAOImpl();
        try {
            List<Reprezentacja> reprezentacjaList = dao.getAllReprezentacja();
            for (Reprezentacja r: reprezentacjaList) {
                modelRep.addElement(r.getNazwa());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        listaReprezentacjiList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                modelZawodnik.removeAllElements();
                if (!listaMundialiList.isSelectionEmpty() || !listaReprezentacjiList.isSelectionEmpty()) {
                    ZawodnikWReprezentacjaDAO dao1 = new ZawodnikWReprezentacjaDAOImpl();
                    String munValue = listaMundialiList.getSelectedValue().toString();
                    String repValue = listaReprezentacjiList.getSelectedValue().toString();
                    try {
                        List<Zawodnik> zawodnikList = dao1.getAllZawodnicyAtMundialInRep(munValue, repValue);
                        for (Zawodnik z: zawodnikList) {
                            String zaw = z.getImie() + " " + z.getNazwisko();
                            modelZawodnik.addElement(zaw);
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }


            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (imieTextField.getText().isEmpty() || nazwiskoTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Imię i nazwisko musi być wypełnione!");
        }
        else { //Dodanie zawodnika do tabeli Zawodnik
            ZawodnikDAO dao = new ZawodnikDAOImpl();
            Zawodnik z = new Zawodnik();
            z.setImie(imieTextField.getText());
            z.setNazwisko(nazwiskoTextField.getText());
            try {
                dao.addZawodnik(z);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



            //Pobranie idMundialu z tabeli Mundial  po zaznaczeniu mundialu w JlistMundial i zapisanie w zmiennej idMun3
            MundialDAO mundialDAO = new MundialDAOImpl();
            Mundial m3 = null;
            try {
                m3 = mundialDAO.getMundialByLokalizacja(listaMundialiList.getSelectedValue().toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            int idMun3 = m3.getIdMundialu();

            //Pobranie idReprez z tabeli Reprezentacja  po zaznaczeniu rep w JlistRep i zapisanie w zmiennej idRep3
            ReprezentacjaDAO repDAO = new ReprezentacjaDAOImpl();
            Reprezentacja r3 = null;
            try {
                r3 = repDAO.getIdRepByNazwa(listaReprezentacjiList.getSelectedValue().toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            int idRep3 = r3.getIdReprezentacji();


            //Pobranie idZawodnika z tabeli Zawodnik  poprzez(imie,nazw) ktore wpisalismy w textfieldy i zapisanie do zmiennej idZaw3
            ZawodnikDAO dao2 = new ZawodnikDAOImpl();
            List<Zawodnik> zawodnicy = null;
            int idZaw = 0;
            try {
                zawodnicy = dao2.getZawodnicyByImieNazwisko(imieTextField.getText(), nazwiskoTextField.getText());

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            for (Zawodnik z1: zawodnicy) {
                idZaw = z1.getIdZawodnika();
            }

            //Dodanie zawodnika,reprezentacji oraz mundialu do tabeli Zawodnicy_W_reprezentacji
            ZawodnikWReprezentacjaDAO dao1 = new ZawodnikWReprezentacjaDAOImpl();
            try {
                dao1.addZawodnikRepMundial(idZaw, idRep3, idMun3);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            // Pobranie zawartosci listy jest na poczatku klasy, w tym kodzie ponizej bedzie wizualne dodanie elementu do listy i bazodanowe usuniecie z listy
            // tak by nie wczytywac do listyZawodnikowList zawartosci z bazy danych
            // Ponizszy kod ma za zadanie tylko wizualnie pokazac dodanie elementu do listy
            String zawodnikWizualizacja = imieTextField.getText() + " " + nazwiskoTextField.getText();
            modelZawodnik.addElement(zawodnikWizualizacja);


        }

    }
}
