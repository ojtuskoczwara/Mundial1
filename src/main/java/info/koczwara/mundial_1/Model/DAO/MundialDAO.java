package info.koczwara.mundial_1.Model.DAO;


import info.koczwara.mundial_1.Model.Entity.Mundial;

import java.util.List;

public interface MundialDAO {
    public void addMundial(Mundial mundial) throws Exception;
    public List<Mundial> getAllMundial() throws Exception;
    public Mundial getMundialByLokalizacja(String lokalizacja) throws Exception;

}
