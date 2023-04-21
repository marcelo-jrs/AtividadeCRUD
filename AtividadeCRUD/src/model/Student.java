package model;

import control.DepartmentCRUD;

public class Student {

    private int ID;
    public String name;
    public int dept;
    public float cred;

    public Student(String name, int dept, float cred) {
        this.name = name;
        this.dept = dept;
        this.cred = cred;
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

    public float getCred() {
        return cred;
    }

    public void setCred(float cred) {
        this.cred = cred;
    }
}
