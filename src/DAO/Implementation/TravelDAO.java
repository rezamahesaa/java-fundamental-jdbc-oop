package DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.InterfaceTravelDAO;

public class TravelDAO implements InterfaceTravelDAO{
    private Connection connection;

    public TravelDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Travel> get(){
        List<Travel> travels = new ArrayList<>();
        String query = "SELECT * FROM tbl_tr_travel;";
        try {
            ResultSet rs = connection.prepareStatement(query).executeQuery();
            while (rs.next()) {
                Travel travel = new Travel(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("hotel_expense"), rs.getInt("transport_expense"), rs.getInt("other_expense"), rs.getInt("total_expense"), rs.getString("submit_date"));
                travels.add(travel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return travels;
    }

    public Travel get(int inputID){
        Travel travel = null;
        String query = "SELECT * FROM tbl_tr_travel WHERE id = ?;";
        try {
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setInt(1, inputID);
            try(ResultSet rs = getById.executeQuery()){
                if(rs.next()){
                    travel = new Travel(rs.getInt("id"), rs.getInt("employee_id"), rs.getInt("hotel_expense"), rs.getInt("transport_expense"), rs.getInt("other_expense"), rs.getInt("total_expense"), rs.getString("submit_date"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return travel;
    }

    public int calculateTotal(int inputID){
        int affectedRows = 0;
        String query = "UPDATE tbl_tr_travel SET total_expense = ? WHERE id = ?;";
        Travel travel = get(inputID);
        if(travel == null){
            return affectedRows;
        }
        try {
            PreparedStatement calculateStatement = connection.prepareStatement(query);
            travel.calculateTotal();
            calculateStatement.setInt(1, travel.getTotalExpense());
            calculateStatement.setInt(2, travel.getId());
            affectedRows = calculateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
        return affectedRows;
    }
}
