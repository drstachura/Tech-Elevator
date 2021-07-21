package com.techelevator.projects.model.jdbc;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<>();

		String sqlgetAllEmployee = " SELECT * "
								 + " FROM Employee ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetAllEmployee);

		while (results.next()) {
			Employee theEmps = mapRowToEmp(results);
			employeeList.add(theEmps);
		}
		return employeeList;

	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employeeName = new ArrayList<>();

		String sqlSearchEmployeeByName = " SELECT * "
										+ " FROM Employee "
										+ " WHERE first_name ilike ? AND last_name ilike ? ";

		SqlRowSet theEmployeeNames = jdbcTemplate.queryForRowSet(sqlSearchEmployeeByName, firstNameSearch +"%", lastNameSearch + "%");

		while(theEmployeeNames.next()) {
			Employee theEmpName = mapNameToEmp(theEmployeeNames);
			employeeName.add(theEmpName);
		}
		return employeeName;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> theEmployee = new ArrayList<>();

		String sqlGetEmployeeByDepartmentId = "SELECT * "
											+ " FROM Employee "
											+ " WHERE department_id = ?";

		SqlRowSet theResults = jdbcTemplate.queryForRowSet(sqlGetEmployeeByDepartmentId, id);

		while(theResults.next()) {
			Employee theEmpNameByDept = mapRowToEmp(theResults);
			theEmployee.add(theEmpNameByDept);
		}

		return theEmployee;
	}



	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> theEmployeesWithoutProjects = new ArrayList();



		return theEmployeesWithoutProjects;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> theEmployeeProject = new ArrayList<>();

		//use a Join
		String sqlGetEmployeeByProjectId = "SELECT first_name, last_name "
				+ " FROM Employee "
				+ " INNER JOIN Project "
				+ " WHERE project_id = ?";

		SqlRowSet theResults = jdbcTemplate.queryForRowSet(sqlGetEmployeeByProjectId, projectId);

		while(theResults.next()) {
			Employee theEmpNameByProj = mapRowToEmpProj(theResults);
			theEmployeeProject.add(theEmpNameByProj);
		}

		return theEmployeeProject;

	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlChangeEmployeeDepartment = "UPDATE Employee "
								           + " SET department_id = ? "
											+ " WHERE employee_id = ? ";

		jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId, employeeId);
	}




	/*----------HELPERS-------------------------------*/
	private Employee mapRowToEmp(SqlRowSet results) {
		Employee theEmp = new Employee();
		theEmp.setEmpId(results.getLong("employee_id"));
		theEmp.setDeptId(results.getLong("department_id"));
		theEmp.setFirstName(results.getString("first_name"));
		theEmp.setLastName(results.getString("last_name"));
		theEmp.setBirthDate(results.getDate("birth_date").toLocalDate());
		theEmp.setGender(results.getString("gender"));
		theEmp.setHireDate(results.getDate("hire_date").toLocalDate());
		return theEmp;
	}

	private Employee mapNameToEmp(SqlRowSet results) {
		Employee theEmpName = new Employee();
		theEmpName.setFirstName(results.getString("first_name"));
		theEmpName.setLastName(results.getString("last_name"));
		return theEmpName;
	}

	private Employee mapRowToEmpProj(SqlRowSet results) {
		Employee theEmpProj = new Employee();
		theEmpProj.setFirstName(results.getString("first_name"));
		theEmpProj.setLastName(results.getString("last_name"));
		return theEmpProj;
	}

}
