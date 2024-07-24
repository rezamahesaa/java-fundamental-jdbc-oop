package DAO.Implementation;

public class Allowance implements InterfaceAllowance{
    private int id;
    private int employeeId;
    private int totalInsuranceExpense;
    private int thr;
    private int totalTravelExpense;
    private int totalAllowance;   

    public Allowance(int id, int employeeId, int totalInsuranceExpense, int thr, int totalTravelExpense,
            int totalAllowance) {
        this.id = id;
        this.employeeId = employeeId;
        this.totalInsuranceExpense = totalInsuranceExpense;
        this.thr = thr;
        this.totalTravelExpense = totalTravelExpense;
        this.totalAllowance = totalAllowance;
    }

    public Allowance(){

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
    public int getTotalInsuranceExpense() {
        return totalInsuranceExpense;
    }
    public void setTotalInsuranceExpense(int totalInsuranceExpense) {
        this.totalInsuranceExpense = totalInsuranceExpense;
    }
    public int getThr() {
        return thr;
    }
    public void setThr(int thr) {
        this.thr = thr;
    }
    public int getTotalTravelExpense() {
        return totalTravelExpense;
    }
    public void setTotalTravelExpense(int totalTravelExpense) {
        this.totalTravelExpense = totalTravelExpense;
    }
    public int getTotalAllowance() {
        return totalAllowance;
    }
    public void setTotalAllowance(int totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    public void calculateTotal(){
        setTotalAllowance(totalInsuranceExpense + totalTravelExpense);
    }
    
}
