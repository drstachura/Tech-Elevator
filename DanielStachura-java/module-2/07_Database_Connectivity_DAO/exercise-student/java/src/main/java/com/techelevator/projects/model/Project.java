package com.techelevator.projects.model;

import java.time.LocalDate;

public class Project {
	// TODO: Place code to describe the columns in the table row here

//data members/instance variable
    private long projectId;
    private String projectName;
    private LocalDate fromDate;
    private LocalDate toDate;

//get/set
    public long getprojectId() {
        return projectId;
    }
    public void setprojectId(long projectId) {
        this.projectId = projectId;
    }
    public String getprojectName() {
        return projectName;
    }
    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    public LocalDate getToDate() {
        return toDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

//toString
    @Override
    public String toString() {
        return "Project{"
                + "Project Name= "
                + projectName
                + "}";
    }

}//End
