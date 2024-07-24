package DAO;
import java.util.List;
import DAO.Implementation.*;

public interface InterfaceEmployeeDAO {
    public List<Employee> get();
    public Employee get(int inputID);
    public int insert(Employee employee);
    public int update(Employee employee);
    public int delete(int inputID);
}
