package info.koczwara.mundial_1.Model.DAO;


import info.koczwara.mundial_1.Model.Entity.Mundial;
import info.koczwara.mundial_1.Model.Entity.Reprezentacja;
import info.koczwara.mundial_1.Model.Entity.Zawodnik;

import java.util.ArrayList;
import java.util.List;

public interface ZawodnikWReprezentacjaDAO {
    public List<Mundial> getAllMundiale() throws Exception;
    public void addMundial(Mundial mundial) throws Exception;
    public List<Reprezentacja> getAllReprezentacje() throws Exception;
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception;
    public List<Zawodnik> getAllZawodnicy() throws Exception;
    public void addZawodnik(Zawodnik zawodnik) throws Exception;
}
