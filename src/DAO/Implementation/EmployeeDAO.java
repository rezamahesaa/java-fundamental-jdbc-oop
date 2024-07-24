package DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.InterfaceEmployeeDAO;

public class EmployeeDAO implements InterfaceEmployeeDAO{
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> get(){
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM tbl_m_employee;";
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getInt("job_id"), resultSet.getInt("placement_id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address"), resultSet.getString("email"), resultSet.getString("phone"), resultSet.getInt("gross_salary"), resultSet.getInt("take_home_pay"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public Employee get(int inputID){
        String query = "SELECT * FROM tbl_m_employee WHERE id = ?;";
        Employee employee = null;
        try {
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setInt(1, inputID);
            try(ResultSet resultSet = getById.executeQuery()){
                if(resultSet.next()){
                    employee = new Employee(resultSet.getInt("id"), resultSet.getInt("job_id"), resultSet.getInt("placement_id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address"), resultSet.getString("email"), resultSet.getString("phone"), resultSet.getInt("gross_salary"), resultSet.getInt("take_home_pay"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }
    
    public int insert(Employee employee){
        int affectedRows = 0;
        String query = "INSERT INTO tbl_m_employee (id, job_id, placement_id, name, age, address, email, phone) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement insertStatement = connection.prepareStatement(query);
            insertStatement.setInt(1, employee.getId());
            insertStatement.setInt(2, employee.getJobId());
            insertStatement.setInt(3, employee.getPlacementId());
            insertStatement.setString(4, employee.getName());
            insertStatement.setInt(5, employee.getAge());
            insertStatement.setString(6, employee.getAddress());
            insertStatement.setString(7, employee.getEmail());
            insertStatement.setString(8, employee.getPhone());
            affectedRows = insertStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affectedRows;
    }

    public int update(Employee employee){
        int affectedRows = 0;
        String query = "UPDATE tbl_m_employee SET name = ? WHERE id = ?;";
        Employee validEmployee = get(employee.getId());
        if(validEmployee == null){
            return affectedRows;
        }
        try {
            PreparedStatement updateStatement = connection.prepareStatement(query);
            updateStatement.setString(1, employee.getName());
            updateStatement.setInt(2, employee.getId());
            affectedRows = updateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return affectedRows;
    }

    public int delete(int inputID){
        int affectedRows = 0;
        String query = "DELETE FROM tbl_m_employee WHERE id = ?;";
        Employee validEmployee = get(inputID);
        if(validEmployee == null){
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

}
