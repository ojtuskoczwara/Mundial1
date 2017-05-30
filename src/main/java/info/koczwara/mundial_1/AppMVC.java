package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller1EkranGlowny;
import info.koczwara.mundial_1.View.View1EkranGlowny;


public class AppMVC {
    public static void main(String[] args) {
/*
        ZawodnikView view = new ZawodnikView();
        Zawodnik model = new Zawodnik();
        Controller controller = new Controller(view, model);

        view.setVisible(true);

*/

        View1EkranGlowny view = new View1EkranGlowny();
        Controller1EkranGlowny controller = new Controller1EkranGlowny(view);
        view.setVisible(true);
    }
}
