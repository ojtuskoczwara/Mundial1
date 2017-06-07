package info.koczwara.mundial_1.Model.dao;


import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;

import java.util.List;

public interface ZawodnikWReprezentacjaDAO {
    public List<Zawodnik> getAllZawodnicyAtMundialInRep(String mundialValue, String repValue) throws Exception;
    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception;
    public List<Reprezentacja> getAllReprezentacjeAtMundial(String mundialName, int mundialRok) throws Exception;
    public int getIdZawodnikByLokalizacjaNazwaImieNazwisko(String mundialLokalizacja, String reprezentacjaNazwa, Zawodnik zawodnik) throws Exception;
    public Zawodnik getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception;
    public void deleteRowsByMundialIdReprezentacjaIdZawodnikId(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception;

}
