package DAO;

import java.util.List;

import DAO.Implementation.Travel;

public interface InterfaceTravelDAO {
    public List<Travel> get();
    public Travel get(int inputID);
    public int calculateTotal(int inputID);

}
