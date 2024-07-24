package DAO;
import java.util.List;
import DAO.Implementation.*;


public interface InterfaceUserDAO {
    public List<User> get();
    public User get(int inputID);
    public int insert(User user);
    public int update(User user);
    public int delete(int inputID);
    public User userLogin(String username, String password);
}
