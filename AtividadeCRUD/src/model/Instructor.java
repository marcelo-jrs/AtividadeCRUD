package model;

import control.DepartmentCRUD;

public class Instructor {

    private int ID;
    public String name;
    public int dept;
    public float salary;

    public Instructor(String name, int dept, float salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDept() {
        return dept;
    }

    public String getDeptString() {
        DepartmentCRUD crudDep = new DepartmentCRUD();
        Department dep = crudDep.getById(dept);
        String deptName = dep.getDeptName();
        return deptName;
    }

    public void setDep(int dept) {
        this.dept = dept;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
