package com.techelevator.projects.model;

public class Department {
// TODO: Place code to describe the columns in the table row here

//data members/instance variable
    private long departmentId;
    private String departmentName;

//get/set
    public long getdepartmentId() {
        return departmentId;
    }
    public void setdepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
    public String getdepartmentName() {
        return departmentName;
    }
    public void setdepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//toString
    @Override
    public String toString() {
        return "Department{"
                + "Department Name= "
                + departmentName
                + "}";
    }

}//End