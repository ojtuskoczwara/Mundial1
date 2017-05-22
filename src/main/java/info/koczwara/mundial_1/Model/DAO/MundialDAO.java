package info.koczwara.mundial_1.Model.DAO;


import info.koczwara.mundial_1.Model.Entity.Mundial;

import java.sql.SQLException;
import java.util.List;

public interface MundialDAO {
    public void addMundial(Mundial mundial) throws Exception;

    public List<Mundial> getAllMundial() throws Exception;

    public Mundial getMundialByLokalizacja(String lokalizacja) throws Exception;

    public int deleteMundialByIdMundialu(int idMundialu) throws SQLException;

    public Mundial getMundialByLokalizacjaRok(String lokalizacja, int rok) throws Exception;

    public int updateMundial(int idMundialu, String nowaLokalizacja, int nowyRok) throws SQLException;

    public int getMundialByLokalRok(String lokalizacja, int rok) throws Exception;

}
