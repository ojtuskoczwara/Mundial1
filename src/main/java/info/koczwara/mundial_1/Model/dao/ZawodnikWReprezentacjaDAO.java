package info.koczwara.mundial_1.Model.dao;


import info.koczwara.mundial_1.Model.entity.Mundial;
import info.koczwara.mundial_1.Model.entity.Reprezentacja;
import info.koczwara.mundial_1.Model.entity.Zawodnik;

import java.util.List;

public interface ZawodnikWReprezentacjaDAO {
    public List<Mundial> getAllMundiale() throws Exception;
    public void addMundial(Mundial mundial) throws Exception;
    public List<Reprezentacja> getAllRepAtMundial(String mundialValue) throws Exception;
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception;
    public List<Zawodnik> getAllZawodnicyAtMundialInRep(String mundialValue, String repValue) throws Exception;
    public void addZawodnik(Zawodnik zawodnik) throws Exception;

    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception;
}
