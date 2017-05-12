package info.koczwara.mundial_1.Model.DAO;


import info.koczwara.mundial_1.Model.Entity.Reprezentacja;

import java.util.List;

public interface ReprezentacjaDAO {
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception;
    public Reprezentacja getReprezentacjaById(int id) throws Exception;
    public List<Reprezentacja> getAllReprezentacja() throws Exception;
    public void deleteReprezentacja(int id) throws Exception;
    public void updateReprezentacja(Reprezentacja reprezentacja) throws Exception;
}
