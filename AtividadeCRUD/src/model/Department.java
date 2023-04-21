package model;

public class Department {

    private  int ID;
    public String deptName;
    public String building;
    public float budget;

    public Department(String deptName, String building, float budget){
        super();
        this.deptName = deptName;
        this.building = building;
        this.budget = budget;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }


}
