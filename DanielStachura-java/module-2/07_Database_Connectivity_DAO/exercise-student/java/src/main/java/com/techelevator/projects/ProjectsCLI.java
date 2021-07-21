package com.techelevator.projects;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;
import com.techelevator.projects.view.Menu;
/******************************************************************************************
 * This is the application program to test your DAO's
 * 
 * This code compiles and runs successfully as long as you follow the instructions below
 * 
 * YOU SHOULD NOT HAVE TO CHANGE ANYTHING LOGIC IN THIS CODE
 * 
 * YOU WILL NEED TO DE-COMMENT CODE THAT IS DEPENDENT ON YOUR POJO for the class
 * MUCH OF THE COMMENTED OUT CODE IS DEPENDENT UPON STANDARD GETTERS AND SETTERS in the POJO
 * 
 * PLEASE READ THE COMMENTS WHERE POJO GETTERS AND SETTERS ARE USED (or if you are getting compile errors
 *        IF YOUR GETTERS AND SETTERS HAVE DIFFERENT NAMES THAN WHAT IS CODED,
 *           CHANGE THE CODE TP MATCH THE NAMES OF YOUR GETTER/SETTERS
 * 
 ******************************************************************************************/
public class ProjectsCLI {
	
	private static final String MAIN_MENU_OPTION_EMPLOYEES = "Employees";
	private static final String MAIN_MENU_OPTION_DEPARTMENTS = "Departments";
	private static final String MAIN_MENU_OPTION_PROJECTS = "Projects";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_DEPARTMENTS, 
																	 MAIN_MENU_OPTION_EMPLOYEES, 
																	 MAIN_MENU_OPTION_PROJECTS, 
																	 MAIN_MENU_OPTION_EXIT };

	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";

	private static final String DEPT_MENU_OPTION_ALL_DEPARTMENTS = "Show all departments";
	private static final String DEPT_MENU_OPTION_SEARCH_BY_NAME = "Department search by name";
	private static final String DEPT_MENU_OPTION_DEPARTMENT_EMPLOYEES = "Show department employees";
	private static final String DEPT_MENU_OPTION_ADD_DEPARTMENT = "Add a new department";
	private static final String DEPT_MENU_OPTION_UPDATE_NAME = "Update department name";
	private static final String[] DEPARTMENT_MENU_OPTIONS = new String[] { DEPT_MENU_OPTION_ALL_DEPARTMENTS,
																		   DEPT_MENU_OPTION_SEARCH_BY_NAME,
																		   DEPT_MENU_OPTION_DEPARTMENT_EMPLOYEES,
																		   DEPT_MENU_OPTION_ADD_DEPARTMENT,
																		   DEPT_MENU_OPTION_UPDATE_NAME,
																		   MENU_OPTION_RETURN_TO_MAIN};
	
	private static final String EMPL_MENU_OPTION_ALL_EMPLOYEES = "Show all employees";
	private static final String EMPL_MENU_OPTION_SEARCH_BY_NAME = "Employee search by name";
	private static final String EMPL_MENU_OPTION_EMPLOYEES_NO_PROJECTS = "Show employees without projects";
	private static final String EMPL_MENU_OPTION_CHANGE_DEPARTMENT = "Change employee's department";
	private static final String[] EMPL_MENU_OPTIONS = new String[] { EMPL_MENU_OPTION_ALL_EMPLOYEES,
																	 EMPL_MENU_OPTION_SEARCH_BY_NAME,
																	 EMPL_MENU_OPTION_EMPLOYEES_NO_PROJECTS,
																	 EMPL_MENU_OPTION_CHANGE_DEPARTMENT,
																	 MENU_OPTION_RETURN_TO_MAIN};
	
	private static final String PROJ_MENU_OPTION_ACTIVE_PROJECTS = "Show active projects";
	private static final String PROJ_MENU_OPTION_PROJECT_EMPLOYEES = "Show project employees";
	private static final String PROJ_MENU_OPTION_ASSIGN_EMPLOYEE_TO_PROJECT = "Assign an employee to a project";
	private static final String PROJ_MENU_OPTION_REMOVE_EMPLOYEE_FROM_PROJECT = "Remove employee from project";
	private static final String[] PROJ_MENU_OPTIONS = new String[] { PROJ_MENU_OPTION_ACTIVE_PROJECTS,
																	 PROJ_MENU_OPTION_PROJECT_EMPLOYEES,
																	 PROJ_MENU_OPTION_ASSIGN_EMPLOYEE_TO_PROJECT,
																	 PROJ_MENU_OPTION_REMOVE_EMPLOYEE_FROM_PROJECT,
																	 MENU_OPTION_RETURN_TO_MAIN };
/******************************************************************************************
 * 	Define instance variable objects needed by all methods in the class 
 ******************************************************************************************/	
	private Menu menu;                    // Define TE provided menu class object
	private DepartmentDAO departmentDAO;  // Define DepartmentDAO object - it is instantiated in the ctor
	private EmployeeDAO employeeDAO;      // Define EmployeeDAO object - it is instantiated in the ctor
	private ProjectDAO projectDAO;        // Define ProjectDAO object  - it is instantiated in the ctor 
	
	public static void main(String[] args) {
		ProjectsCLI application = new ProjectsCLI();  // Define and instantiate application code
		application.run();                            // Start the applications
	}

	/******************************************************************************************
	 * 	This is theConstructor for the application processing code	
	 ******************************************************************************************/
	public ProjectsCLI() {  
		this.menu = new Menu(System.in, System.out);   // Instantiate a Menu object
		                                               //   and assign to Menu object for this class
/******************************************************************************************
 * 	Normally we would have you code the data source yourself
 *  We provide it for you this time so you can focus on the POJOs and DAO implementations	
 ******************************************************************************************/
		BasicDataSource dataSource = new BasicDataSource();             // Define and instantiate a data source
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projectsDAO"); // Set the connection string for the data source
		dataSource.setUsername("postgres");                             // Set the user name that owns the database
		dataSource.setPassword("postgres1");                            // Set the password for the owner of the database

/******************************************************************************************
 * 	Normally we would have you instantiate the DAO objects yourself
 *  We provide it for you this time so you can focus on the POJOs and DAO implementations	
 ******************************************************************************************/
	
		departmentDAO = new JDBCDepartmentDAO(dataSource); // instantiate DAO object and assign to instance variable
		employeeDAO   = new JDBCEmployeeDAO(dataSource);   // instantiate DAO object and assign to instance variable
		projectDAO    = new JDBCProjectDAO(dataSource);    // instantiate DAO object and assign to instance variable
	}

/******************************************************************************************
 * 	This is the main processing loop for the application
 ******************************************************************************************/
	private void run() {
		displayApplicationBanner();	
		while(true) {
			printHeading("Main Menu");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_DEPARTMENTS)) {
				handleDepartments();
			} else if(choice.equals(MAIN_MENU_OPTION_EMPLOYEES)) {
				handleEmployees();
			} else if(choice.equals(MAIN_MENU_OPTION_PROJECTS)) {
				handleProjects();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("\n" + "-".repeat(60) + "\n Thanks for running our application"+ "\n" + "-".repeat(60) + "\n");
				System.exit(0);
			}
		}
	}

	private void handleDepartments() {
		printHeading("Departments");
		String choice = (String)menu.getChoiceFromOptions(DEPARTMENT_MENU_OPTIONS);
		if(choice.equals(DEPT_MENU_OPTION_ALL_DEPARTMENTS)) {
			handleListAllDepartments();
		} else if(choice.equals(DEPT_MENU_OPTION_SEARCH_BY_NAME)) {
			handleDepartmentSearch();
		} else if(choice.equals(DEPT_MENU_OPTION_DEPARTMENT_EMPLOYEES)) {
			handleDepartmentEmployeeList();
		} else if(choice.equals(DEPT_MENU_OPTION_ADD_DEPARTMENT)) {
			handleAddDepartment();
		} else if(choice.equals(DEPT_MENU_OPTION_UPDATE_NAME)) {
			handleUpdateDepartmentName();
		} 
	}

	private void handleAddDepartment() {
		printHeading("Add New Department");
		String newDepartmentName = getUserInput("Enter new Department name");
		Department newDepartment = new Department();
		newDepartment.setdepartmentName(newDepartmentName);  // If your setter is not called "setName()", change this to what yours is called
		newDepartment = departmentDAO.createDepartment(newDepartment);     // Use the DAO object to run DAO method
		System.out.println("\n*** "+newDepartment.getdepartmentId()+" created ***");  // If your getter are not called "getName()", change this to what yours is called
	}
	
	private void handleUpdateDepartmentName() {
		printHeading("Update Department Name");
		List<Department> allDepartments = departmentDAO.getAllDepartments();// Use the DAO object to run DAO method
		if(allDepartments.size() > 0) {
			System.out.println("\n*** Choose a Department ***");
			Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
			String newDepartmentName = getUserInput("Enter new Department name");
			selectedDepartment.setdepartmentName(newDepartmentName);     // If your setter is not called "setName()", change this to what yours is called
			departmentDAO.saveDepartment(selectedDepartment);  // Use the DAO object to run DAO method
		} else {
			System.out.println("\n*** No results ***");
		}
	}

	private void handleListAllDepartments() {
		printHeading("All Departments");
		List<Department> allDepartments = departmentDAO.getAllDepartments(); // Use the DAO object to run DAO method
		listDepartments(allDepartments);
	}

	private void handleDepartmentSearch() {
		printHeading("Department Search");
		String departmentSearch = getUserInput("Enter department name to search for");
		List<Department> departments = departmentDAO.searchDepartmentsByName(departmentSearch); // Use the DAO object to run DAO method
		listDepartments(departments);
	}
	
	private void handleDepartmentEmployeeList() {
		printHeading("Department Employee List");
		List<Department> allDepartments = departmentDAO.getAllDepartments();  // Use the DAO object to run DAO method
		if(allDepartments.size() > 0) {
			System.out.println("\n*** Choose a Department ***");
			Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
			List<Employee> departmentEmployees = employeeDAO.getEmployeesByDepartmentId(selectedDepartment.getdepartmentId());  // If your getter is not called "getId()", change this to what yours is called
			listEmployees(departmentEmployees);
		} else {
			System.out.println("\n*** No results ***");
		}
	}

	private void listDepartments(List<Department> departments) {
		System.out.println();
		if(departments.size() > 0) {
			for(Department dept : departments) {
				System.out.println(dept.getdepartmentName()); // If your getter is not called "getName()", change this to what yours is called
			}
		} else {
			System.out.println("\n*** No results ***");
		}
	}
	
	private void handleEmployees() {
		printHeading("Employees");
		String choice = (String)menu.getChoiceFromOptions(EMPL_MENU_OPTIONS);
		if(choice.equals(EMPL_MENU_OPTION_ALL_EMPLOYEES)) {
			handleListAllEmployees();
		} else if(choice.equals(EMPL_MENU_OPTION_SEARCH_BY_NAME)) {
			handleEmployeeSearch();
		} else if(choice.equals(EMPL_MENU_OPTION_EMPLOYEES_NO_PROJECTS)) {
			handleUnassignedEmployeeSearch();
		} else if(choice.equals(EMPL_MENU_OPTION_CHANGE_DEPARTMENT)) {
			handleChangeEmployeeDepartment();
		}
	}

	private void handleListAllEmployees() {
		printHeading("All Employees");
		List<Employee> allEmployees = employeeDAO.getAllEmployees();  // Use the DAO object to run DAO method
		listEmployees(allEmployees);
	}

	private void handleEmployeeSearch() {
		printHeading("Employee Search");
		String firstNameSearch = getUserInput("Enter first name to search for");
		String lastNameSearch = getUserInput("Enter last name to search for");
		List<Employee> employees = employeeDAO.searchEmployeesByName(firstNameSearch, lastNameSearch); // Use the DAO object to run DAO method
		listEmployees(employees);
	}

	private void handleUnassignedEmployeeSearch() {
		printHeading("Unassigned Employees");
		List<Employee> employees = employeeDAO.getEmployeesWithoutProjects(); // Use the DAO object to run DAO method
		listEmployees(employees);
	}
	
	private void listEmployees(List<Employee> employees) {
		System.out.println();
		if(employees.size() > 0) {
			for(Employee emp : employees) {
				System.out.println(emp.getLastName() + ", " + emp.getFirstName()); // If your getters are not called "getLastName()" and "getFirstName(), change this to what yours is called
			}
		} else {
			System.out.println("\n*** No results ***");
		}
	}
	
	private void handleChangeEmployeeDepartment() {
		printHeading("Change Employee Department");
		
		System.out.println("Choose an employee to transfer:");
		List<Employee> allEmployees = employeeDAO.getAllEmployees();  // Use the DAO object to run DAO method
		Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(allEmployees.toArray());
		
		System.out.println("Choose the new department:");
		List<Department> allDepartments = departmentDAO.getAllDepartments();  // Use the DAO object to run DAO method
		Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
		
		employeeDAO.changeEmployeeDepartment(selectedEmployee.getEmpId(), selectedDepartment.getdepartmentId());  // If your getters are not called "getId()", change this to what yours is called
	}

	private void handleProjects() {
		printHeading("Projects");
		String choice = (String)menu.getChoiceFromOptions(PROJ_MENU_OPTIONS);
		if(choice.equals(PROJ_MENU_OPTION_ACTIVE_PROJECTS)) {
			handleListActiveProjects();
		} else if(choice.equals(PROJ_MENU_OPTION_PROJECT_EMPLOYEES)) {
			handleProjectEmployeeList();
		} else if(choice.equals(PROJ_MENU_OPTION_ASSIGN_EMPLOYEE_TO_PROJECT)) {
			handleEmployeeProjectAssignment();
		}  else if(choice.equals(PROJ_MENU_OPTION_REMOVE_EMPLOYEE_FROM_PROJECT)) {
			handleEmployeeProjectRemoval();
		}
	}

	private void handleListActiveProjects() {
		printHeading("Active Projects");
		List<Project> projects = projectDAO.getAllActiveProjects();  // Use the DAO object to run DAO method
		listProjects(projects);
	}

	private void handleEmployeeProjectRemoval() {
		printHeading("Remove Employee From Project");
		
		Project selectedProject = getProjectSelectionFromUser();
		
		System.out.println("Choose an employee to remove:");
		List<Employee> projectEmployees = employeeDAO.getEmployeesByProjectId(selectedProject.getprojectId());  // If your getter is not called "getId()", change this to what yours is called
		if(projectEmployees.size() > 0) {
			Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(projectEmployees.toArray());
			projectDAO.removeEmployeeFromProject(selectedProject.getprojectId(), selectedEmployee.getEmpId()); // If your getters are not called "getId()", change this to what yours is called
			System.out.println("\n*** "+selectedEmployee+" removed from "+selectedProject+" ***");
		} else {
			System.out.println("\n*** No results ***");
		}
	}

	private void handleEmployeeProjectAssignment() {
		printHeading("Assign Employee To Project");
		
		Project selectedProject = getProjectSelectionFromUser();
		
		System.out.println("Choose an employee to add:");
		List<Employee> allEmployees = employeeDAO.getAllEmployees();   // Use the DAO object to run DAO method
		Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(allEmployees.toArray());
		
		projectDAO.addEmployeeToProject(selectedProject.getprojectId(), selectedEmployee.getEmpId());  // If your getters are not called "getId()", change this to what yours is called
		System.out.println("\n*** "+selectedEmployee+" added to "+selectedProject+" ***");
	}
	
	private void handleProjectEmployeeList() {
		Project selectedProject = getProjectSelectionFromUser();
		List<Employee> projectEmployees = employeeDAO.getEmployeesByProjectId(selectedProject.getprojectId());  // If your getters are not called "getId()", change this to what yours is called
		listEmployees(projectEmployees);
	}

	private Project getProjectSelectionFromUser() {
		System.out.println("Choose a project:");
		List<Project> allProjects = projectDAO.getAllActiveProjects();
		return (Project)menu.getChoiceFromOptions(allProjects.toArray());
	}
	
	private void listProjects(List<Project> projects) {
		System.out.println();
		if(projects.size() > 0) {
			for(Project proj : projects) {
				System.out.println(proj.getprojectName());   // If your getter are not called "getName()", change this to what yours is called
			}
		} else {
			System.out.println("\n*** No results ***");
		}
	}

	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	private String getUserInput(String prompt) {
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}

	private void displayApplicationBanner() {
		System.out.println(" ______                 _                         _____           _           _     _____  ____");
		System.out.println("|  ____|               | |                       |  __ \\         (_)         | |   |  __ \\|  _ \\");
		System.out.println("| |__   _ __ ___  _ __ | | ___  _   _  ___  ___  | |__) | __ ___  _  ___  ___| |_  | |  | | |_) |");
		System.out.println("|  __| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\ |  ___/ '__/ _ \\| |/ _ \\/ __| __| | |  | |  _ <");
		System.out.println("| |____| | | | | | |_) | | (_) | |_| |  __/  __/ | |   | | | (_) | |  __/ (__| |_  | |__| | |_) |");
		System.out.println("|______|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___| |_|   |_|  \\___/| |\\___|\\___|\\__| |_____/|____/");
		System.out.println("                 | |             __/ |                          _/ |");
		System.out.println("                 |_|            |___/                          |__/");
		System.out.println();
	}
}
