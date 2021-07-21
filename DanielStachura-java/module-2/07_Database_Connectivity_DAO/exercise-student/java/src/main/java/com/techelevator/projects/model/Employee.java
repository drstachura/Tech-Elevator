package com.techelevator.projects.model;

import java.time.LocalDate;

public class Employee {
	// TODO: Place code to describe the columns in the table row here

//data members/instance variable
    private long empId;
    private long deptId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private LocalDate hireDate;

//get/set
    public long getEmpId() {
        return empId;
    }
    public void setEmpId(long empId) {
        this.empId = empId;
    }
    public long getDeptId() {
        return deptId;
    }
    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

//toString
    @Override
    public String toString() {
        return "Employee{"
                + "lastName= "
                + lastName
                + ", firstName= "
                + firstName
                + "}";
    }

}//End
