package DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.InterfaceUserDAO;

public class UserDAO implements InterfaceUserDAO{
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> get(){
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM tbl_m_user;";
        try {
            ResultSet rs = connection.prepareStatement(query).executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("role_id"), rs.getString("username"), rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public User get(int inputID){
        String query = "SELECT * FROM tbl_m_user WHERE id = ?;";
        User user = null;
        try {
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setInt(1, inputID);
            try(ResultSet rs = getById.executeQuery()){
                if(rs.next()){
                    user = new User(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("role_id"), rs.getString("username"), rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public int insert(User user){
        int affectedRows = 0;
        String query = "INSERT INTO tbl_m_user (employee_id, role_id, username, password) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement insertStatement = connection.prepareStatement(query);
            insertStatement.setInt(1, user.getEmployeeId());
            insertStatement.setInt(2, user.getRoleId());
            insertStatement.setString(3, user.getUsername());
            insertStatement.setString(4, user.getPassword());
            affectedRows = insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return affectedRows;
    }

    public int update(User user){
        int affectedRows = 0;
        String query = "UPDATE tbl_m_user SET username = ?, password = ? WHERE id = ?;";
        User validUser = get(user.getId());
        if(validUser == null){
            return affectedRows;
        }
        try {
            PreparedStatement updateStatement = connection.prepareStatement(query);
            updateStatement.setString(1, user.getUsername());
            updateStatement.setString(2, user.getPassword());
            updateStatement.setInt(3, user.getId());
            affectedRows = updateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affectedRows;
    }

    public int delete(int inputID){
        int affectedRows = 0;
        String query = "DELETE FROM tbl_m_user WHERE id = ?";
        User validUser = get(inputID);
        if(validUser == null){
            return affectedRows;
        }
        try {
            PreparedStatement deleteStatement = connection.prepareStatement(query);
            deleteStatement.setInt(1, inputID);
            affectedRows = deleteStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affectedRows;
    }

    public User userLogin(String username, String password){
        User validUser = get().stream()
            .filter(u -> ((u.getUsername().equals(username)) && (u.getPassword().equals(password))))
            .findFirst()
            .orElse(null);
        return validUser;
    }

}
