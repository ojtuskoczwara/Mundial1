package info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora;

import info.koczwara.mundial_1.Model.DAO.MundialDAO;
import info.koczwara.mundial_1.Model.DAO.MundialDAOImpl;
import info.koczwara.mundial_1.Model.Entity.Mundial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReprezentacjaDodajView extends JFrame implements ActionListener {
    private JLabel nazwaLabel = new JLabel("Nazwa reprezentacji:");
    private JTextField nazwaTextField = new JTextField();
    private JButton dodajButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList listaMundialiList;



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
        JList listaReprezentacjiList = new JList(modelRep);
        listaReprezentacjiList.setBounds(200,20,120,200);
        add(listaReprezentacjiList);


        nazwaLabel.setBounds(50,300,120,30);
        add(nazwaLabel);
        nazwaTextField.setBounds(180,300,150,30);
        add(nazwaTextField);
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



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        nazwaTextField.setText(listaMundialiList.getSelectedValue().toString());
    }
}
