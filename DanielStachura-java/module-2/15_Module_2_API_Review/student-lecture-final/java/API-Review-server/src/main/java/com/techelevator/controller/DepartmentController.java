package com.techelevator.controller;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Controller to process API requests
 */
@RestController  // Tell the server there are methods ih here to handle URL paths it get
public class DepartmentController {

// Define a reference to the Department DAO so we can handle API calls to get Department data
DepartmentDAO theDeptData;

// Constructor for the controller class to receive DAO object(s) and and assign to our reference(s)
// Spring will Dependency Inject the DAO object when it instantiates the controller
//        so we don't have to know or care about the concrete class is actually called
//                 (we are loosely coupled to the concrete class for the DAO)
    public DepartmentController(DepartmentDAO theDeptMethods) {
        theDeptData = theDeptMethods;
    }

// Write  controller to handle an API class to get all the departments
//
//  HTTP Request: GET
//  path:   /departments     - no path variable or query string variables needed
//
//  to get data use Department DAO method:
//
//                 public List<Department> getAllDepartments();

@RequestMapping(path="/department", method=RequestMethod.GET)
public List<Department> getTheDepartments() {
    logAPICall("GET  - /department");    // log the request and path we received
    List<Department> theDepartments = new ArrayList();   // hold the result to be returned

    theDepartments = theDeptData.getAllDepartments();  // Call the DAO to get the data

    return theDepartments;
//  return theDeptData.getAllDepartments();  // Call the DAO to get the data and return it
    }

// Write a controller to add a new Department to the department resource
//
//    HTTP Request: POST
//    Path: /department
//
//  DAO method to use:
//
//           public Department createDepartment(Department newDepartment);
//

    @RequestMapping(path="/department", method=RequestMethod.POST)
    // @RequestBody - Get the data from the request body and store it in a Department object
public Department addNewDepartment(@RequestBody Department newDepartment) {
    logAPICall("POST - /department");
    return   theDeptData.createDepartment(newDepartment);
    }

public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}  // End of controller class


