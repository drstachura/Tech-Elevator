package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {					//getting null pointer exception for the DATE
	/*	ArrayList<Project> allActiveProject = new ArrayList<>();

		String sqlgetAllActiveProjects = "Select * "
										+ " from project ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetAllActiveProjects);

		while (results.next()) {
			Project theProjects = mapRowToProject(results);
			allActiveProject.add(theProjects);
		}
		return allActiveProject;*/
		return null;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
	/*	String sqlDeleteEmployeeToProject = "DELETE FROM project_employee "
										+ " WHERE project_id = ? "
										+ " AND employee_id = ? ";

		jdbcTemplate.update(sqlDeleteEmployeeToProject, projectId, employeeId);*/
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
	/*	String sqlAddEmployeeToProject = "UPDATE project_employee "
										+ " SET project_id = ? "
										+ " WHERE employee_id = ? ";

		jdbcTemplate.update(sqlAddEmployeeToProject, projectId, employeeId);*/
	}

	//******************************* Helper Methods **************************************************//

/*	private Project mapRowToProject(SqlRowSet results) {
		Project theProj = new Project();
		theProj.setprojectId(results.getLong("project_id"));
		theProj.setprojectName(results.getString("name"));
//		theProj.setFromDate(results.getDate("from_date").toLocalDate());
//		theProj.setToDate(results.getDate("to_date").toLocalDate());

		Date projectFromDate = results.getDate("from_date");
		if (!(results.wasNull())) {
			theProj.setFromDate(projectFromDate.toLocalDate());
		}

		Date projectToDate = results.getDate("to_date");
		if (!(results.wasNull())) {
			theProj.setFromDate(projectToDate.toLocalDate());
		}

		return theProj;
	}*/

}//END
