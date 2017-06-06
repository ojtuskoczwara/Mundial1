package info.koczwara.mundial_1.Controller;


import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;
import info.koczwara.mundial_1.Model.entity.ZawodnikWReprezentacja;
import info.koczwara.mundial_1.View.EkranGlowny.PanelAdministratora.ViewZawodnikUsun;

import javax.swing.*;

public class ControllerZawodnikUsun {
    private ViewZawodnikUsun view;
    private Zawodnik modelZawodnik;
    private Reprezentacja modelReprezentacja;
    private Mundial modelMundial;
    private ZawodnikWReprezentacja modelZawodnikWReprezentacja;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel reprezentacjaListModel = new DefaultListModel();
    private DefaultListModel zawodnikListModel = new DefaultListModel();


    public ControllerZawodnikUsun(ViewZawodnikUsun view, Zawodnik modelZawodnik, Reprezentacja modelReprezentacja, Mundial modelMundial, ZawodnikWReprezentacja modelZawodnikWReprezentacja){

    }
}
