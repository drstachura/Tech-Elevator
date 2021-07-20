package com.techelevator;

import jdk.jshell.SourceCodeAnalysis;

import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Application {
    // defining these outside any method make them available to every method in this class, no need to worry
    // about how to get them
    //  Global Objects
    public static List<Department> departments = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static List<Employee> deptMarketing = new ArrayList<>();
    public static List<Employee> deptSales = new ArrayList<>();
    public static List<Employee> deptEngineering = new ArrayList<>();
    public static Map<String, Project> projects = new HashMap();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {

        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();

    }

    /**
     * Create departments and add them to the collection of departments
     */
    public static void createDepartments() {

     //   Department Marketing = new Department();
     //   Department Sales = new Department();
     //   Department Engineering = new Department();
        Department marketing = new Department(001, "Marketing");
        Department sales = new Department(002, "Sales");
        Department engineering = new Department(003, "Engineering");

        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    //    System.out.println(departments) ;
    //    System.out.println(departments.size());


    }

    /**
     * Print out each department in the collection.
     */
    public static void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());
        }
    }
    //    System.out.println(Marketing);
    //    System.out.println(Sales);
    //    System.out.println(Engineering);  // pretty sure  a for loop will pull them in




    /**
     * Create employees and add them to the collection of employees
     */
    private static void createEmployees() {
/*
 //  **Tip: use the Departments from the departments list to assign each employee's department. Retrieve
 //           the two departments you need by using the get() method.**

 //      *use no-argument constructor and call setter methods to set each instance variable
 //   employeeId = 001;
 //   firstName = Dean;
//    lastName = Johnson;
//    email = djohnson@teams.com;
 //   salary = 60000;
//    department = Engineering;
 //   hireDate = 08/21/2020

//        *use all-argument constructor
 */

 //   employeeId = 002;
 //   firstName = Angie;
 //   lastName = Smith;
//    email = asmith@teams.com;
 //   salary = 60000; -> 10% increase
 //   department = Engineering;       //department.get(2);
  //  hireDate = 08/21/2020

/*        *use all-argument constructor
    employeeId = 003;
    firstName = Margaret;
    lastName = Thompson;
    email = mthompson@teams.com;
    salary = 60000;
    department = Marketing;         //department.get(0);
    hireDate = 08/21/2020
 */
 //      Employee dean = new Employee();
  //            this.department= departments.get(2);

        Employee dean = new Employee(001, "Dean", "Johnson", "djohnson@teams.com", departments.get(2), "08/21/2020");
        Employee angie = new Employee(002, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        {angie.setSalary(angie.getSalary()/10 + angie.getSalary());

        }




        Employee margaret= new Employee(003, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");

        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);
    }
// giveAngie a 10% raise
   /* public void raiseSalary(double percent) {
        salary = salary * (10.0 + (percent/100));
*/
    /**
     * Print out each employee in the collection.
     */
    private static void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");


        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getFullName() + " (" + employees.get(i).getSalary() + ") " +
                    employees.get(i).getDepartment().getName());

        }

/*  (fullName + " (" + salary + ") " + department)
    (fullName + " (" + salary + ") " + department)
    (fullName + " (" + salary + ") " + department)

 */
    }

    /**
     * Create the 'Teams' project.
     */
    private static void createTeamsProject() {
       /* name: TEams
        description: Project Management Software
        startDate: 10/10/2020
        dueDate: 11/10/2020

        Teams.put(Dean Johnson);
        Teams.put(Angie Smith);
 */
        //creates a project just like department and employee
        Project TEams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        //go through all employees and see if they are in Engineering, if so add them, if not move on
        // for each loop
        for (Employee employee  : employees   ) {
        //  data-type name      :   loop thru
            if (employee.getDepartment().getName().equals("Engineering")) {
                deptEngineering.add(employee);
            }
        }
        TEams.setTeamMembers(deptEngineering);
        //set the engineers to the team members of the project

        projects.put(TEams.getName(), TEams);

   //     projects.containsKey("name")


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private static void createLandingPageProject() {
/*
        name: Marketing Landing Page
        description: Lead Capture Landing Page for Marketing
        startDate: 10/10/2020
        dueDate: 10/17/2020

        MarketingLandingPage.put(Margaret Thompson)
 */
        Project Marketing = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",
                "10/10/2020", "10/17/2020");

        for (Employee employee  : employees   ) {
            if (employee.getDepartment().getName().equals("Marketing")) {
                deptMarketing.add(employee);
            }
        }
        Marketing.setTeamMembers(deptMarketing);

        projects.put(Marketing.getName(), Marketing);
        }

    /**
     * Print out each project in the collection.
     */
    private static void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        System.out.println("TEams: " + deptEngineering.size());

        System.out.println("Marketing Landing Page: " + deptMarketing.size());
/*  print number of employees on the project
        Teams: 2
        Marketing Landing Page: 1
 */
    }

}
