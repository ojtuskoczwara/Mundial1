package info.koczwara.mundial_1;

import info.koczwara.mundial_1.Controller.Controller1_0_EkranGlowny;
import info.koczwara.mundial_1.View.View1_0_EkranGlowny;


public class AppMVC {
    public static void main(String[] args) {
/*
        ZawodnikView view = new ZawodnikView();
        Zawodnik model = new Zawodnik();
        Controller controller = new Controller(view, model);

        view.setVisible(true);

*/

        View1_0_EkranGlowny view = new View1_0_EkranGlowny();
        Controller1_0_EkranGlowny controller = new Controller1_0_EkranGlowny(view);
        view.setVisible(true);
    }
}
