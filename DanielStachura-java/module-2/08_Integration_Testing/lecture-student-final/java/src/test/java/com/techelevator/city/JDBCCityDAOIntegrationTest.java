package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // Optional - List the test in alphabetical order by name

public class JDBCCityDAOIntegrationTest {
	//
	// This will data base access using DAO for the City table
	//

	// Define constants for use in creating nw rows for testing in the table
	private static final String TEST_COUNTRY = "XYZ";  // Assuming that countrycode XYZ is not not already in any table

	// Since we are testing data base access methods - we need to define a data source

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;  // Define a reference to the datasource
	                                                       // datasource is instantiated and assigned in the testing

	private JDBCCityDAO dao;     // Define a reference to the object containing the methods to be tested
	                             // this will be instantiated and assigned during testing

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass  // Do this when the this class is instantiated - Stuff to be done ONCE that every method needs
	public static void setupDataSource() {  // JUnit test methods always return void and accept no parameters
		dataSource = new SingleConnectionDataSource();              // instantiate the datasource and assign to reference
		//             type-of-access:databasemgr://databaseserver:port/database
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");// set datasource connection string
		dataSource.setUsername("postgres");                         // set the user that owns the database
		dataSource.setPassword("postgres1");                        // set the password for the user that owns the database
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);  // tell the database we will control commit/rollback
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass  // Do this ONCE before the class is destroyed - end of testing
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();   // close the datasource to release resources and avoid resource leaks
	}

	@Before  // Do this before each test is run - typically this will set up test data
	         // Avoid using actually data from database in your testing - it could change from test to test
	         // Test should be repeatable and reliable - if the data changes from one test session to another
	         //      the repeatability and reliability is compromised.
	         // You should always add data to a database for testing that you KNOW is not already in the database
	         //     and remove it when you are done testing
	public void setup() {

		// Since a City is dependent on a country
		//   we will add a test country to our database that we KNOW is not already in the database
		//           for use without test cities

		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
				                                "VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";

		// We want top be sure we a "clean" jdbcTemplate object so we define a new one for each test
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Run the insert with the TEST_COUNTRY we setup earlier we is not already in the country table
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);

		// Instantiate and assign a fresh DAO with the methods we are testing for every test
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();  // Undo any changes made to the database during the test
	}
//
// Start of individual DAO method testing
//
	@Test   // Every test must start with @Test or JUnit doesn't see it
	// Each test in in a separate JUnit method
	// JUnit methods return void accept no parameters and should have verbose, meaningful names
	public void save_new_city_and_read_it_back() throws SQLException {
		// When creating a test:
		//     Arrange - set up any test data required for the test
		//     Act     - Run the method with the test data you arranged and get the result
		//     Assert - verify the result is what was expected
		//
		//     Any one of these steps may require multiple statements or be combined in to a single statement
		//

		// Arrange a new City object to use in in the test
		// Since the primary key of City is a serial value, we know that this row is not already in the table
		//       the database manager will generate a unique value for the primary key
		// Note: Use of an existing code (USA) is not necessarily a good idea
		//       it would be safer to use our TEST_COUNTRY instead of the existing country code "USA"

		// When adding an object to a table where the primary key is generated
		// we do not provide a primary key in the object we are saving to the database
		// In this case, the City id is generated so we don't provide it in the object
		// The DAO method should set the primary key (id) in the object as part of it's processing

		// Create a test City object using a Helper method - getCity()
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);

		// Act - call the save method with the test city to add to add it to the table
		dao.save(theCity);

		// Get a City object from the City table for the id of the City we just saved
		City savedCity = dao.findCityById(theCity.getId());

		// In the above line of code we are using a method - findCityById() - in the DAO we are testing
		// This may be considered "bad practice" some coding environments
		//      and OK in others IF you have tested that method successfully to before used
		//
		// The reason some consider it bad practice is this test no independent of of processing as it should be
		// In this case if findCityById() is incorrect the results of our test are not reliable
		//
		// If we did not use the findCityById() method we would have written a Helper method
		//       to go to the database with a SELECT, mapped the result to a City object and returned it

		// Assert - verify the the City object we got from the data in the table matches the City Object we saved
		assertNotEquals(null, theCity.getId());    // Verify that a City object we saved got an id assigned
		assertCitiesAreEqual(theCity, savedCity);  // Verify the City object returned from the data base matches
		                                           //        the City object we sent using a Helper Method
		                                           // assertCitiesAreEqual() is NOT a JUnit test
		                                           //        its a Helper Method we wrote for testing
	}

	// Test when multiple rows may be returned from a DAO method
	// Using two tests - one if only a single row is in the table and one if multiple rows are in table
	// Sometimes multiple tests are required to fully test a method
	@Test
	public void returns_cities_by_country_code() {
		// Arrange - Define a test City with out primary key (id) using our TEST_COUNTRY
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Act - Add one new object to the data base
		dao.save(theCity);
		// Get the result of the Act by retreiving only rows for our test country
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

	    // Assert - Verify result
		assertNotNull(results);                      // Verify did we get something back from the method?
		assertEquals(1, results.size());             // Verify only one row came back (we only added one)
		City savedCity = results.get(0);             // Get the first object in the List
		assertCitiesAreEqual(theCity, savedCity);    // Verify the object we got from the List matches the only sent
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		// Arrange - add multiple City objects to the table
		// Instantiate new object and calling the method all in one statement
		// We are using the TEST_COUNTRY so we know only the rows we add have that value
		// Arrange and Act are in the same statement
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		// Retrieve the objects added for the TEST_COUNTRY (there should be only 2)
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		assertNotNull(results);           // Verify something was returned (at least one row we added in the table)
		assertEquals(2, results.size());  // Verify exactly 2 rows were returned because we only added 2 rows

		// We did not test for conditions already tested by other test methods
		// We did not check to see if the 2 objects we retrieved matched the 2 objects we sent
		// We COULDN'T since the objects we sent we created in the call to the method and no longer exist
		// If you want to test that the objects retrieved match the object sent - instantiate separate objects
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	/******************************************************************************************************
	 * Helper methods used in the tests to provide common processing that needs to get done
	 ******************************************************************************************************/

	// Create a new City object for testing using values passed for all columns except the primary key

	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	// Assert that each value in the objects passed are equal

	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
