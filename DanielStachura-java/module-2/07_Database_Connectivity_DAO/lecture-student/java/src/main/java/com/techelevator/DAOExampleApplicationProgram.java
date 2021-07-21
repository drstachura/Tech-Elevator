package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExampleApplicationProgram {

	public static void main(String[] args) {

	// Need to define a data source to the database we want to access
		BasicDataSource worldDataSource = new BasicDataSource();			// simple JDBC data source
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");   // connection string
		worldDataSource.setUsername("postgres");							// owner of the database
		worldDataSource.setPassword("postgres1");							// password for owner

	// Define the DAO we want to use and pass it to the datasource we define
		CityDAO dao = new JDBCCityDAO(worldDataSource);

	// Creating new City in the database
		City smallville = new City();		// define a default City Object
		// id was not assigned as it's a serial type in the database manager and the database will assign it
		smallville.setCountryCode("USA");	// use the methods of the City object to assign values
		smallville.setDistrict("KS");		// 	  to the various data members
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		System.out.println("\n  smallville City object defined in the program: " + smallville);

	// We use the DAO object we defined to access the methods of the DAO
		dao.save(smallville);	// us the DAO save method to save our City Object into the database

	// We use the DAO object we defined to access the methods of the DAO
		City theCity = dao.findCityById(smallville.getId());

		System.out.println("\ntheCity City object retrieved from the database: " + theCity);

	}
}
