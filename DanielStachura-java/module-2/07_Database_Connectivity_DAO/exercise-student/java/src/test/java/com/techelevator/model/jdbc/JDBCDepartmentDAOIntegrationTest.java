package com.techelevator.model.jdbc;

import com.techelevator.projects.model.Department;

import java.util.List;

public class JDBCDepartmentDAOIntegrationTest {

   /* public List<Department> getAllDepartments();
   * what it receives
   *    receives SQL statement
   *
   * what it returns
   *    returns List if departments from the database
   *
   * what is needed to test
   *    need to pass SQL statements to the database
   *
   *    verify all departments were pulled from the database
   *
   * to Test
   *    run SQL statement to pull the query and use helper method to list all columns from the database and
   *        map them to the List to be returned for each possible row in the database
   *
   * */

    /*public List<Department> searchDepartmentsByName(String nameSearch);
    *
    * what it receives
    *   receives String nameSearch
    *
    * what it returns
    *   returns List of departments by name
    *
    * what is needed to test
    *   need to run SQL statement to find department by a name search
    *   verify the department returned from the name that was input
    *
    * to Test
    *   run SQL statement to pull the query and input the name to search
    *   verify the object returned matches the name input
    *
    * */

    /*public void saveDepartment(Department updatedDepartment)
    * what it receives
    *   Department object
    *
    * what is returned
    *   nothing - void
    *
    * what is needed to test
    *   new department object to pass to the method
    *   verify the object passed was set to the database
    *
    * to Test
    *   test department without a name or depatment_id
    *   call the method with test department
    *   retrieve the new department name
    *   verify department name was updated
    *
    * */

   /* public Department createDepartment(Department newDepartment)
   * what it receives
   *    Department object
   *
   * what is returned
   *    Department object
   *
   * what is needed to test
   *    new department object to pass to the method where department_id and name are unknown
   *    use helper method to retrieve new department_id
   *
   *
   * to Test
   *    test department without a name or depatment_id
    *   call the method with test department
    *   retrieve the new department
    *   verify department name was created
   *
   * */


    /*public Department getDepartmentById(Long id)
    * * what it receives
     *   receives Long id
     *
     * what it returns
     *   returns Department object
     *
     * what is needed to test
     *   need to run SQL statement to find department by id search
     *   verify the department returned from the id that was input
     *
     * to Test
     *   run SQL statement to pull the query and input the id to search
     *   verify the object returned matches the id input
     *
     * */

}


/* Methods that were not testable and why:
private Department mapRowToDept(SqlRowSet results) - Helper method
private long getNextDeptId() - Helper method
*/