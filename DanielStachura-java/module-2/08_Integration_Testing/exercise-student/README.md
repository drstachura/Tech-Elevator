# Project Organizer - Integration Testing

Create a Unit Test project for the **Project Organizer Database** application you created in the DAO Exercise.

Implement integration tests for the `JDBCDepartmentDAO`, `JDBCEmployeeDAO`, and `JDBCProjectDAO` classes.

Be sure to clean up any test data so that the database is returned to its original state after the test is completed.

You will need to create a new package in `src/test/java` called `com.techelevator.model.jdbc`.
You should create a new class in that package called `JDBCtablenameDAOIntegrationTest` for each JDBCDAO you are testing.

Your tests will be coded in the `JDBCtablenameDAOIntegrationTest` class

### Hints: ### 
1. Look at the methods required by the DAO Interface.  
2. Determine what they are supposed to do, return and receive.
3. Construct tests to send the method what it supposed to receive and test what it is supposed to send back.
4. If a method returns `void`, determine how it was supposed to modify the data base and verify it did so correctly.
5. Remember: **Analyze**, **Design**, **Code** and when you code,  **Arrange**, **Act**, **Assert**.
6. It may take a bit of hard thinking during **Analyze** to determine how to test a method, this is normal and an expected part of the exercise. 
7. Some methods may **not** lend itself to JUnit tests, if you determine that is the case, code comments near the top of your solution with the method header from the DAO interface and why you think it is not viable to test with JUnit test.  For example:

```
/* Methods that were not testable and why:
      
    Object methodMcMethMeth(String str); - Helper method
    int    function1*( );                - Could not determine how to test
    
*/
  ```
