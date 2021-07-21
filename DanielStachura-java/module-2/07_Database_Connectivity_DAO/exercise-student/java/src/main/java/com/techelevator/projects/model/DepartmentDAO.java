package com.techelevator.projects.model;

import java.util.List;

public interface DepartmentDAO {

	/**
	 * Get all departments from the data store.
	 * 
	 * @return all departments as Department objects in a List
	 */
	public List<Department> getAllDepartments();

	/**
	 * Get all the departments whose name contains the search string. Remember
	 * to use LIKE or ILIKE to do a fuzzy match on the search.
	 * 
	 * @param nameSearch the search string to look for in the department name
	 * @return all matching departments as Department objects in a List
	 */
	public List<Department> searchDepartmentsByName(String nameSearch);

	/**
	 * Update a department to the data store. Only called on departments that
	 * are already in the data store.
	 * 
	 * @param updatedDepartment the department object to update
	 */
	public void saveDepartment(Department updatedDepartment);

	/**
	 * Inserts a new department into the data store.
	 * 
	 * @param newDepartment the department object to insert
	 * @return the department object with its new id filled in
	 */
	public Department createDepartment(Department newDepartment);

	/**
	 * Get a department from the data store that belongs to the given id.
	 * 
	 * @param id the department id to get from the data store
	 * @return a filled out department object
	 */
	public Department getDepartmentById(Long departmentId);
}
