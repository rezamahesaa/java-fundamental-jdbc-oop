package DAO.Implementation;

public class Employee {
    private int id;
    private int jobId;
    private int placementId;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phone;
    private int grossSalary;
    private int takeHomePay;
    
    // for displaying data
    public Employee(int id, int jobId, int placementId, String name, int age, String address, String email, String phone) {
        this.id = id;
        this.jobId = jobId;
        this.placementId = placementId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    // this constructor is for insert and update
    public Employee(int jobId, int placementId, String name, int age, String address, String email, String phone) {
        this.jobId = jobId;
        this.placementId = placementId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    

    public Employee(int id, int jobId, int placementId, String name, int age, String address, String email,
            String phone, int grossSalary, int takeHomePay) {
        this.id = id;
        this.jobId = jobId;
        this.placementId = placementId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.grossSalary = grossSalary;
        this.takeHomePay = takeHomePay;
    }

    // for subclass (user)
    public Employee(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getJobId() {
        return jobId;
    }
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public int getPlacementId() {
        return placementId;
    }
    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getGrossSalary() {
        return grossSalary;
    }
    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }
    public int getTakeHomePay() {
        return takeHomePay;
    }
    public void setTakeHomePay(int takeHomePay) {
        this.takeHomePay = takeHomePay;
    }

    
}
