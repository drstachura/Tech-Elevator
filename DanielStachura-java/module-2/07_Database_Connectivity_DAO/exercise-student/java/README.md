# Project Organizer - Data Access Objects Exercise


**Setup:** 
1. Create a PostgreSQL database called `projectsDAO`
2. Create a database connection to the database in dbVisualizer
3. Using dbVisualizer run the SQL script `projects_DAO_Schema.sql` in the database path of the exercise.  This will create the tables and other database objects required for the exercise, load data into the tables and establish relationships between the tables.
4. *Optional* Use dbVisualizer to get a graphic depiction of the tables and their relationships.

**Exercise:**

1. Import the `exercise-student` project into IntelliJ.
2. Create the classes for each table (POJOs) with standard getters, setters.
   If you are having IntelliJ generate your getters and setters, be sure you are happy with the names of your instance variables.
   If you change the name of an instance variable after having IntelliJ generate the getters/setters, **YOU** must change the names of the getters/setters to standard names.
   
   The toString() methods for each table should do the following:

       Employee Table - return the lastname, firstname for the employee.  For example:  Fella, Frank

       Project Table - return the project name only

       Department Table - return the department name only

3. The DAOs (interfaces) for each table have been provided, look at them to find out what the associated methods are supposed to do.

4. Complete the implementation of the `JDBCDepartmentDAO`, `JDBCEmployeeDAO`, and `JDBCProjectDAO`.
5. An application program, `projectsCLI` has been provided to test your DAOs. It should run successfully if you have implemented the POJO and JDBC/DAO code correctly.  *YOU SHOULD NOT HAVE TO MAKE ANY CHANGES TO THE LOGIC OF THIS PROGRAM!*.  You will need to make coding changes as indicated in the comments of  the program.
   
**IGNORE ANY TESTS YOU MIGHT FIND IN THE `test` FOLDER.  THEY ARE NOT FOR THIS EXERCISE**

You will know you have successfully completed the exercise when the application program runs without error and produces correct results.
