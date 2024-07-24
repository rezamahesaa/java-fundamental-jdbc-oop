import DAO.*;
import DAO.Implementation.*;

public class App {
    public static void main(String[] args){
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());

        InterfaceEmployeeDAO edao = new EmployeeDAO(connection.getConnection());
        for(Employee employee : edao.get()){
            System.out.println("Id: " + employee.getId() + "\tName: " + employee.getName());
        }
        System.out.println();

        Employee employee1 = edao.get(1);
        System.out.println("Id: " + employee1.getId() + "\tName: " + employee1.getName());
        System.out.println();

        //                              jobId, placementid, name, age, address, email, phone   
        Employee employee2 = new Employee(7, 4 , "Caca", 21, "Cianjur", "emailcaca", "08123");
        System.out.println("Affected Row(s): " + edao.insert(employee2));
        System.out.println();

        //                              id, jobId, placementid, name, age, address, email, phone   
        Employee employee3 = new Employee(14, 1, 1 , "Cici", 21, "Cibubur", "emailcici", "08333");
        System.out.println("Affected Row(s): " + edao.update(employee3));
        System.out.println();

        System.out.println("Affected Row(s): " + edao.delete(17));
        System.out.println();

        InterfaceUserDAO udao = new UserDAO(connection.getConnection());
        for(User user : udao.get()){
            System.out.println("Id: " + user.getId() + "\tEmployee ID: " + user.getEmployeeId() + "\t\tEmployee Name: " + edao.get(user.getEmployeeId()).getName());
            System.out.println("Username: " + user.getUsername() + "\t\tPassword: " + user.getPassword());
        }
        System.out.println();

        User user1 = udao.get(1);
        System.out.println("Id: " + user1.getId() + "\tEmployee ID: " + user1.getEmployeeId() + "\t\tEmployee Name: " + edao.get(user1.getEmployeeId()).getName());
        System.out.println("Username: " + user1.getUsername() + "\t\tPassword: " + user1.getPassword());
        System.out.println();

        //                      empId, roleId, uname, pass
        User user2 = new User(18, 2, "cacacici", "caca123");
        System.out.println("Affected Row(s): " + udao.insert(user2));

        User user3 = new User(14, 18, 2, "cacacaca", "aciaci123");
        System.out.println("Affected Row(s): " + udao.update(user3));

        System.out.println("Affected Row(s): " + udao.delete(14));
        
        User user4 = udao.userLogin("emailzuko", "123");
        String hasilUser4 = (user4!=null) ? ("Halo "  + edao.get(user4.getEmployeeId()).getName() + " ("+ user4.getUsername() + ") !") : ("Username atau password salah");
        User user5 = udao.userLogin("emailzuko", "b1d9f407-3");
        String hasilUser5 = (user5!=null) ? ("Halo "  + edao.get(user5.getEmployeeId()).getName() + " ("+ user5.getUsername() + ") !") : ("Username atau password salah");
        System.out.println(hasilUser4);
        System.out.println(hasilUser5);
        
        System.out.println();

        InterfaceTravelDAO tdao = new TravelDAO(connection.getConnection());
        for(Travel travel : tdao.get()){
            System.out.println("ID: " + travel.getId()+ "\tEmployee id: " + travel.getEmployeeId() + "\tHotel Expense: " + travel.getHotelExpense() + "\tTransport Expense: " + travel.getTransportExpense() + "\tOther Expense: " + travel.getOtherExpense() + "\tTotal Expense: " + travel.getTotalExpense());
        }
        System.out.println();

        Travel travel1 = tdao.get(58);
        System.out.println("ID: " + travel1.getId()+ "\tEmployee id: " + travel1.getEmployeeId() + "\tHotel Expense: " + travel1.getHotelExpense() + "\tTransport Expense: " + travel1.getTransportExpense() + "\tOther Expense: " + travel1.getOtherExpense() + "\tTotal Expense: " + travel1.getTotalExpense());
        
        // override method calculateTotal dr parent (allowance)
        System.out.println("Affected Row(s): " + tdao.calculateTotal(58));


    }
}
