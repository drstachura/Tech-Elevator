package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.Objects;

public class Employee {

//Instance Variables
    private double salary;
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private String hireDate;

    private static final int STARTING_SALARY = 60000;

//Constructors

    public Employee (long employeeId, String firstName,String lastName, String email, Department department, String hireDate){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
        this.salary = STARTING_SALARY;

    }

    public Employee() {
        this.employeeId = 001;
        this.firstName = "Dean";
        this.lastName = "Johnson";
        this.email = "djohnson@teams.com";
        this.department = null;
        this.hireDate = "08/21/2020";
        this.salary = STARTING_SALARY;
    }

//Methods
    public String getFullName() {
        return (lastName + ", " + firstName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", hireDate='" + hireDate + '\'' +
                '}';

    }
//          equls() ?? do we need all this??
    /*    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return Double.compare(employee.getSalary(),
                    getSalary()) == 0 && getEmployeeId() == employee.getEmployeeId() && Objects.equals(getFirstName(),
                    employee.getFirstName()) && Objects.equals(getLastName(),
                    employee.getLastName()) && Objects.equals(getEmail(),
                    employee.getEmail()) && Objects.equals(getDepartment(),
                    employee.getDepartment()) && Objects.equals(getHireDate(),
                    employee.getHireDate());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSalary(), getEmployeeId(), getFirstName(), getLastName(), getEmail(), getDepartment(), getHireDate());
        }
    */
    public void raiseSalary(double percent) {
       //SALARY(SALARY * (1.0 + (percent/100)));
        salary = STARTING_SALARY * (1.0 + (percent/100));



    }

//Getter/Setter
    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
