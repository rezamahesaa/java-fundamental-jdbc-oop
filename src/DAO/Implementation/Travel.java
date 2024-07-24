package DAO.Implementation;

public class Travel extends Allowance{
    private int id;
    private int employeeId;
    private int hotelExpense;
    private int transportExpense;
    private int otherExpense;
    private int totalExpense;
    private String submitDate;

    public Travel(int id, int employeeId, int hotelExpense, int transportExpense, int otherExpense, int totalExpense,
        String submitDate) {
    this.id = id;
    this.employeeId = employeeId;
    this.hotelExpense = hotelExpense;
    this.transportExpense = transportExpense;
    this.otherExpense = otherExpense;
    this.totalExpense = totalExpense;
    this.submitDate = submitDate;
}

    public Travel(int employeeId, int hotelExpense, int transportExpense, int otherExpense, int totalExpense,
            String submitDate) {
        this.employeeId = employeeId;
        this.hotelExpense = hotelExpense;
        this.transportExpense = transportExpense;
        this.otherExpense = otherExpense;
        this.totalExpense = totalExpense;
        this.submitDate = submitDate;
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
    public int getHotelExpense() {
        return hotelExpense;
    }
    public void setHotelExpense(int hotelExpense) {
        this.hotelExpense = hotelExpense;
    }
    public int getTransportExpense() {
        return transportExpense;
    }
    public void setTransportExpense(int transportExpense) {
        this.transportExpense = transportExpense;
    }
    public int getOtherExpense() {
        return otherExpense;
    }
    public void setOtherExpense(int otherExpense) {
        this.otherExpense = otherExpense;
    }
    public int getTotalExpense() {
        return totalExpense;
    }
    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }
    public String getSubmitDate() {
        return submitDate;
    }
    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    @Override
    public void calculateTotal(){
        setTotalExpense(hotelExpense + transportExpense + otherExpense);
    }
}
