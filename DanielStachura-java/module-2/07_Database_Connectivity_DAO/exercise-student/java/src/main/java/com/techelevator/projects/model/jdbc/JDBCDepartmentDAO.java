package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departmentList = new ArrayList<>();

		String sqlgetAllDepartments = "Select * "
									+ " from Department ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetAllDepartments);

		while (results.next()) {
			Department theDepts = mapRowToDept(results);
			departmentList.add(theDepts);
		}
		return departmentList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departmentName = new ArrayList<>();
		String sqlSearchDepartmentByName = "select * "
										 + " from Department "
										 + " where name ilike ? ";

		SqlRowSet theDepartmentNames = jdbcTemplate.queryForRowSet(sqlSearchDepartmentByName, nameSearch + "%");

		while(theDepartmentNames.next()) {
			Department theDeptName = mapRowToDept(theDepartmentNames);
			departmentName.add(theDeptName);
		}

		return departmentName;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlSaveDepartment = "update Department "
								 + " set name = ? "
									+ "WHERE department_id = ? ";


		jdbcTemplate.update(sqlSaveDepartment, updatedDepartment.getdepartmentName()
											 , updatedDepartment.getdepartmentId());


	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlCreateDepartment = "INSERT into Department (department_id, name) "
								 + " VALUES (?, ?) ";

		newDepartment.setdepartmentId(getNextDeptId());

		jdbcTemplate.update(sqlCreateDepartment , newDepartment.getdepartmentId()
												, newDepartment.getdepartmentName());

		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;

		String sqlGetDepartmentByDepartmentId = "select department_id, name "
											  + " From Department "
				                              + " where department_id = ?";

		SqlRowSet theResults = jdbcTemplate.queryForRowSet(sqlGetDepartmentByDepartmentId, id);

		if(theResults.next()) {
			theDepartment = mapRowToDept(theResults);
		}

		return theDepartment;
	}



	/*----------HELPERS-------------------------------*/

	private Department mapRowToDept(SqlRowSet results) {
		Department theDept = new Department();
		theDept.setdepartmentId(results.getLong("department_id"));
		theDept.setdepartmentName(results.getString("name"));
		return theDept;
	}

	private long getNextDeptId() {
		SqlRowSet nextDeptIdResult = jdbcTemplate.queryForRowSet("select nextval('seq_department_id')");

		if(nextDeptIdResult.next()) {
			return nextDeptIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new Department");
		}
	}
}



