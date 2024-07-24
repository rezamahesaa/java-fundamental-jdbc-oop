package DAO.Implementation;

public class User extends Employee {
    private int id;
    private int employeeId;
    private int roleId;
    private String username;
    private String password;  
    
    public User(int id, int employeeId, int roleId, String username, String password) {
        this.id = id;
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
    }

    public User(int employeeId, int roleId, String username, String password) {
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
