package info.koczwara.mundial_1;

import info.koczwara.mundial_1.View.EkranGlownyView;
import info.koczwara.mundial_1.View.ZawodnikView;

/**
 * Created by Wojtek on 2017-05-09.
 */
public class SprawdzanieViews {

    ZawodnikView zawodnikView;
    EkranGlownyView ekranGlownyView;

    public static void main(String[] args) {

        EkranGlownyView ekranGlownyView = new EkranGlownyView();
        ekranGlownyView.setVisible(true);
    }
}
