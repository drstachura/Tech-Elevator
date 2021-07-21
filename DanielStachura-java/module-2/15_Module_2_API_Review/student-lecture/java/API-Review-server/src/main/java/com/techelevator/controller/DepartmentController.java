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

@RestController // Tells the server there are methods in here to handle URL paths it might get
public class DepartmentController {

// Define a reference to the DepartmentDAO so we can handle API calls to get Department data
    DepartmentDAO theDeptData;

// Constructor for the controller class to receive DAO object(s)(theDeptMethods) and assign it to our reference(theDeptData)
// Spring will Dependency inject the DAO object when it instantiates the controller
//      so we don't have to know/care about the concrete class is actually called
//         (means we are loosely coupled to the concrete class for the DAO)
    public DepartmentController (DepartmentDAO theDeptMethods){
        theDeptData=theDeptMethods;
    }

//----------------------------------------------------------------------------------------------------------------------

// Write a controller to handle an API call to get all departments
//
// HTTP Request: GET
// path: /department   - no path variable or query string variables needed
// to get data use the DepartmentDAO method:
//      public List<Department> getAllDepartments();

@RequestMapping(path="/department" , method=RequestMethod.GET)
    public List<Department> getTheDepartments() {
        logAPICall("GET - /department");    // log the request and path we received

        List<Department> theDepartments = new ArrayList();  // hold the result to be returned
        theDepartments = theDeptData.getAllDepartments();   // call the DAO to get the data
        return theDepartments;

//  return theDepartments.getAllDepartments();  // **same as above.  going directly to the return vs creating reference name
    }

//----------------------------------------------------------------------------------------------------------------------

// Write a controller to add a new Department to the department resource
//
// HTTP Request: POST
// path: /department   - no path variable or query string variables needed
// to get data use the DepartmentDAO method:
//      public Department createDepartment(Department newDepartment);

@RequestMapping(path="/department" , method=RequestMethod.POST)
    public Department addNewDepartment(@RequestBody Department newDepartment) {
        logAPICall("POST - /department");
        return theDeptData.createDepartment(newDepartment);
}


//----------------------------------------------------------------------------------------------------------------------

public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}//END


