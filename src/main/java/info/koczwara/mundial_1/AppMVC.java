package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.ControllerEkranGlowny;
import info.koczwara.mundial_1.View.ViewEkranGlowny;


public class AppMVC {
    public static void main(String[] args) {
/*
        ZawodnikView view = new ZawodnikView();
        Zawodnik model = new Zawodnik();
        Controller controller = new Controller(view, model);

        view.setVisible(true);

*/

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);
    }
}
