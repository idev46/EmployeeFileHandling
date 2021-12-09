public class Employee {

    private String empId;
    private String empName;
    private String empDoB;
    private String empQualf;
    private String empExp;
    private String empPScale;


    public Employee() {

    }

    
    public Employee(String empId, String empName, String empDoB, String empQualf, String empExp, String empPScale) {
        this.empId = empId;
        this.empName = empName;
        this.empDoB = empDoB;
        this.empQualf = empQualf;
        this.empExp = empExp;
        this.empPScale = empPScale;
    }


    // getter and setter
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDoB() {
        return empDoB;
    }

    public void setEmpDoB(String empDoB) {
        this.empDoB = empDoB;
    }

    public String getEmpQualf() {
        return empQualf;
    }

    public void setEmpQualf(String empQualf) {
        this.empQualf = empQualf;
    }

    public String getEmpExp() {
        return empExp;
    }

    public void setEmpExp(String empExp) {
        this.empExp = empExp;
    }

    public String getEmpPScale() {
        return empPScale;
    }

    public void setEmpPScale(String empPScale) {
        this.empPScale = empPScale;
    }

}