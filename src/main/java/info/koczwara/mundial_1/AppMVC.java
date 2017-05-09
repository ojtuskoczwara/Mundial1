package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller;
import info.koczwara.mundial_1.Model.Zawodnik;
import info.koczwara.mundial_1.View.ZawodnikView;


public class AppMVC {
    public static void main(String[] args) {

        ZawodnikView view = new ZawodnikView();
        Zawodnik model = new Zawodnik();
        Controller controller = new Controller(view, model);

        view.setVisible(true);
    }
}
