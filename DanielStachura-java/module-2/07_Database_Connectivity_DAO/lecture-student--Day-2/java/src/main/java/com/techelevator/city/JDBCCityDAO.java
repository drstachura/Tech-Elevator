package com.techelevator.city;  // Same package as POJO and DAO Interface

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

// Concrete class for the DAO - implements the methods required by the interface
//                              and any additional methods that might be necessary

// name tells us the source of the data (JDBC), the name of the table (City) and that it's the DOA
public class JDBCCityDAO implements CityDAO {

	// define a reference to the JdbcTemplate object we will use to access Spring DAO Framework
	private JdbcTemplate jdbcTemplate;

	// constructor for the class which takes the dataSource as a parameter
	// dataSource will be provided when this DAO is instantiated (from application program)
	public JDBCCityDAO(DataSource dataSource) {
		// Instantiate a JdbcTemplate object with the dataSource give and assign it to our reference
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Save the given City object to the database
	@Override // Optional - Asks the compiler to be sure we implementing the method the DAO interface is expecting
	// return nothing and receives a City object
	public void save(City newCity) {
		// Define a String for the SQL statement we want to run using Spring DAO Framework
		// coding ? in the SQL statement where we want to provide values from variables
		//          when we run the statement
		// the number of ? must match the number of values expected by the SQL statement
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";  // ?-indicates a value from a variable when run

		newCity.setId(getNextCityId());  // Set the id of the City object passed to
		                                 //     the next ID the database manager will assign as it's serial
		                                 //     we need to know the id of the new row in the table

		// Use our Spring DAO object to execute the SQL statement
		// .update() is used for INSERT, UPDATE, DELETE SQL statements
		//                 SQL statement, values-each-?-in-statement
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),         // replace the 1st ? with the id in the City object passed
										  newCity.getName(),        // replace the 2nd ? with the name in the City object passed
										  newCity.getCountryCode(), // replace the 3rd ? with the countryCode in the City object passed
										  newCity.getDistrict(),    // replace the 4th ? with the district in the City object passed
										  newCity.getPopulation()); // replace the 5th ? with the population in the City object passed
	}

	// Return a City object from the database for the id (primary key) specified
	@Override
	public City findCityById(long id) {
		City theCity = null;
		// Always put a space after the item coded in the line when using a multi-line SQL statement
		//	to avoid a SQLBadGrammer exception due to concatenation without the space
		// the SQL statement to retrieve the data from the table for the id specified
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";

		// Run the SQL statement specifying values for each ? in the SQL statement
		// Since it's a SELECT statement we use queryForRowSet() to run it
		// an SqlRowSet is returned containing all the rows for the SELECT
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);

		if(results.next()) {					// if the SqlRowSet has a next row - position to it in the result
			theCity = mapRowToCity(results);	// copy the data from the SqlRowSet into a Java object using a helper method
		}
		return theCity;
	}

	// Return all the City objects from the database for the given countryCode
	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	// Return all the City objects from the database for the given district (state)
	@Override
	public List<City> findCityByDistrict(String districtTheyWant) {
		// TODO Auto-generated method stub //copy and paste SQL statement from DBVisualizer
		// Define the return object for the method
		List<City> theCities = new ArrayList();

		// Define the SQL statement to be run as a String with ? as placeholder for values provided when it runs
		String sqlSelectByDistrict = "select * "
				                   + " from city "
								   + " where district = ?";

		//Define the SqlRowSet to hold the results from the SELECT
		SqlRowSet theCitiesFromTheTable;

		// Run the SQL statement using JdbcTemplate and store the results in my SqlRowSet
		// Specify the values for any ? in the SQL statement when we run it - usually parameter passed to the method
		theCitiesFromTheTable = jdbcTemplate.queryForRowSet(sqlSelectByDistrict, districtTheyWant);

		// Add the data from the SqlRowSet to the ArrayList we are returning as City objects
		while(theCitiesFromTheTable.next()) {	//loop as long as there are rows in the SqlRowSet
												// next will position the cursor to the next row and return true or return false if no more rows
			City aCity;		// Define a reference to a new City object
			aCity = mapRowToCity(theCitiesFromTheTable);	// Use the helper method to copy a row from the SqlRowSet to the new City object

			theCities.add(aCity);	// Add the new City object with the data from row to the ArrayList we are returning
		}

		return theCities;	// Return the Arraylist with the Cities for the district passed to the method
	}

	// Update the City data in the database using the City object passed
	@Override
	public void update(City cityForUpdate) {

// To update a single row in a table we need to know it's Primary Key(PK)
// Since we are receiving an object that represents the row, it must be assumed...
//		the variable representing the PK must be set to the value of the row to be updated
//		Any data that will change needs to be changed in the object
//		Any data that is NOT changed will also be in the object as it is now in the table

// It is much easier to update all values in the row using values in the object
//		than it is to try and figure out which values should be updated

		// ALL columns EXCEPT the PK columns are coded in the set
		// the PK columns are in the WHERE clause
		String SqlUpdateStatement = "update city "
							      	+ " set population = ? "
				                  	+ " ,name = ? "
									+ " ,countrycode = ? "
									+ " ,district = ? "
									+ " where id =? ";
		//Execute the update statement using the jdbcTemplate object and the value from the object passed
		jdbcTemplate.update(SqlUpdateStatement	, cityForUpdate.getPopulation()   	//get the population from City object passed for the 1st ?
		                                      	, cityForUpdate.getName()			//get the name from City object passed for the 2nd ?
												, cityForUpdate.getCountryCode()	//get the contrycode from City object passed for the 3rd ?
												, cityForUpdate.getDistrict()		//get the district from City object passed for the 4th ?
												, cityForUpdate.getId()				//get the id from City object passed for the 5th ?
													);


		
	}

	// Delete the city data in the database for the given id(PK)
	@Override
	public void delete(long idToBeDeleted) {
		//Define the SQL Delete statement with the WHERE clause for what to delete
		String SqlDeleteStmt = "Delete from City where id = ?";

		//Run the DELETE statement using .update()
		jdbcTemplate.update(SqlDeleteStmt, idToBeDeleted);
		
	}

	//--------------------------------------------------------------------------------------------------------------
	//  Helper methods (not required by DAO interface) - do some common processing we need to get done
	//--------------------------------------------------------------------------------------------------------------

	// Get the next City id from the database manager
	//     because is is defined as a serial value - meaning the database manager will generate a unique integer
	// Since we need to know what id the database is going generate for the new row because we want to store in the
	//       City object passed to us - we need to retrieve from the database manager before do the INSERT
	//
	// PostgreSQL uses sequence objects to keep track of serial values
	// we can ask the sequence object to give us it's next value by SELECTing nextval('seq-object-name')
	private long getNextCityId() {
		// a SELECT SQL statement is expected to return a result of 0 or more rows
		// We need store to the result the SELECT in an SqlRowSet object when using the Spring DAO Framework


		// get the next value from sequence object called seq_city_id
		// and store it in an SqlRowSet object called nextIdResult
		// we use the .queryForRowSet() when running a SELECT because it returns a RowSet
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");


		if(nextIdResult.next()) {              // if there is a row in the SqlRowSet object
			return nextIdResult.getLong(1);    // get the serial value from it as a Long and return it- getLong(1) - get the first column as a Long
		} else {                               // if there is NO row in the SqlRowObject (cuz we are expecting one)
			throw new RuntimeException("Something went wrong while getting an id for the new city");  // Throw an exception
		}
	}

	// Return a City object from the data retrieved from the database
	// Since Java needs objects and the data from the SQL is a SqlRowSet
	// We typically code a method to create a Java object from an SqlRowSet
	// We usually call this 'Map' something because you are mapping the SQL data to a Java object
	// A SqlRowSet is the set of rows returned from a query (SELECT)
	// You must position the cursor for the SqlRowSet to the row in the set you want to be processed
	// Positioning the cursor is usually done with next() which moves to the next row in the SqlRowSet and returns true
	// 														or returns false if the SqlRowSet is empty or you're at the end
	// When the SqlRowSet is returned by the JdbcTemplate method we are positioned BEFORE the first row
	//		we need to do a next() to get to the first row (similar to using nextLine() when processing a file)
	private City mapRowToCity(SqlRowSet results) {	//Receive a SqlRowSet positioned att he row to be mapped
													// and return a City object
		// This method assumes all columns for the table are included in the SqlRowSet
		// If they are not, this method will fail

		City theCity;											//Define a reference to hold the City object to be returned
		theCity = new City();									//Instantiate a City object and assign it to the reference
	//  City theCity = new City();	// This is OK too.  Define a reference, instantiate object and assign it in one statement

	// Set the attributes in the new City object from the values in the SqlRowSet using the object setters
		theCity.setId(results.getLong("id"));						//get the value for id from the SqlRowSet and assign to City object
		theCity.setName(results.getString("name"));					//get the value for name from the SqlRowSet and assign to City object
		theCity.setCountryCode(results.getString("countrycode"));	//get the value for countrycode from the SqlRowSet and assign to City object
		theCity.setDistrict(results.getString("district"));			//get the value for district from the SqlRowSet and assign to City object
		theCity.setPopulation(results.getInt("population"));		//get the value for population from the SqlRowSet and assign to City object
		return theCity;		// return the City object with the data from the SqlRowSet
	}
}
