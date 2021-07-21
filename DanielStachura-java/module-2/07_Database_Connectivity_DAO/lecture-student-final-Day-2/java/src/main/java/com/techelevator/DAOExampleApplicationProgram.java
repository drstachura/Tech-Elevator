package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

import com.techelevator.rental.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DAOExampleApplicationProgram {

	public static void main(String[] args) {

		// Need to define a data source to the database we want to access
		BasicDataSource worldDataSource = new BasicDataSource();         // simple JDBC data source
		//                    access:dbmgr:server-name:port/databasename
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");// connection string
		worldDataSource.setUsername("postgres");                         // owner of the database
		worldDataSource.setPassword("postgres1");                        // password for owner

		// Need to define a data source to the database we want to access
		BasicDataSource dvdstoreDataSource = new BasicDataSource();          // simple JDBC data source
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore"); // connection string
		dvdstoreDataSource.setUsername("postgres");                             // owner of the database
		dvdstoreDataSource.setPassword("postgres1");                            // password for owner

		// Define the DAO object we want to use and pass it the datasource we defined
		CityDAO cityTableDao     = new JDBCCityDAO(worldDataSource);
		RentalDAO rentalTableDao = new JDBCRentalDAO(dvdstoreDataSource);

		System.out.println("\n"+"-".repeat(40) + "\n" + "City Table Access" + "\n" + "-".repeat(40));

		City smallville = new City();      // define a default City object
		// id was not assigned as it's a serial type in the database and the DAO or database manager will assign it
		smallville.setCountryCode("USA");  // Use the methods of the City object to assign values
		smallville.setDistrict("KS");      //     to the various data members
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		System.out.println("\n  smallville City object defined in the program: " + smallville);
		// we use the dao object we defined to access the methods of the DAO
		cityTableDao.save(smallville);   // use the dao save method to save our City object into the database

		// Verify that the City object was actually saved to the database by trying to retrieve it
		// we use the dao object we defined to access the methods of the DAO
		// Retrieve the City from the database with the id passed to the method
		City theCity = cityTableDao.findCityById(smallville.getId());  // get the row with the smallville id from the database

		System.out.println("\ntheCity City object retrieved from the database: " + theCity);

		// Ask the DAO to find all the Cities for Ohio
		// Since DAO method returns a List<City> and we want an ArrayList<City>
		// We need to cast the List<City> that comes back from method to ArrayList<City>
		ArrayList<City> someCities = (ArrayList<City>) cityTableDao.findCityByDistrict("Ohio");

		// List<City> someCities = cityTableDao.findCityByDistrict("Ohio");  // Use this style to avoid cast

		// Display all the City objects returned from the DAO (process ecah element in the List/ArrayList
		for(City aCity : someCities){
			System.out.println(aCity.getName());  // use the getName() method for City to to only get the name
		}

		// Update the population for Amsterdam (id=5) to 300000
		// Get the existing row for Amsterdam (id-5) into a City object so Java can use
		City cityToChange = cityTableDao.findCityById(5);

		System.out.println(cityToChange);  // Display the current values in the CIty to be changed

		// Change the population in the City object to new value
		cityToChange.setPopulation(14);

		// Change the name in the City object to new value
		cityToChange.setName("Brian McBriBri");

		// Call the DAO to update the City
		cityTableDao.update(cityToChange);

		City updatedCity = cityTableDao.findCityById(5);  // get the data from table for the City again
		System.out.println(updatedCity);                  // Display the current values in the City to be changed

		System.out.println("\n Before Delete: " + cityTableDao.findCityById(246));  // For testing - BEFORE - display the City to be deleted

		cityTableDao.delete(246);

		System.out.println("\n After Delete: " + cityTableDao.findCityById(246));  // For testing - AFTER- display the City to be deleted


		System.out.println("\n"+"-".repeat(40) + "\n" + "Rental Table Access" + "\n" + "-".repeat(40));

		System.out.println("-".repeat(25) + " Get rental id: 15862"+ "-".repeat(25));

		System.out.println(rentalTableDao.getARental(15862));

		System.out.println("\n"+"-".repeat(25) + " Get All Rentals"+ "-".repeat(25));
		for (Rental aRental : (ArrayList<Rental>)rentalTableDao.getAllRentals()) {
			System.out.println(aRental + "\n" + "-".repeat(80));
		}

		System.out.println("\n"+"-".repeat(25) + " Get Rentals for customer # 74"+ "-".repeat(25));
		for (Rental aRental : (ArrayList<Rental>)rentalTableDao.getRentalsForCustomer(74)) {
			System.out.println(aRental + "\n" + "-".repeat(80));
		}

		System.out.println("-".repeat(25) + " Delete rental id: 14"+ "-".repeat(25));

		rentalTableDao.removeRental(14);

		System.out.println("-".repeat(25) + " Delete rentals from  id: 14"+ "-".repeat(25));

		int numberRentalsDeleted = 0;

		LocalDateTime fromDate = LocalDateTime.of(2005,06,01,0,0,0);
		LocalDateTime toDate   = LocalDateTime.of(2005,06,30,23,59,59);

		numberRentalsDeleted = rentalTableDao.removeRentalForDateRange(fromDate,toDate);

		System.out.println(numberRentalsDeleted + " rows deleted for date range " + fromDate + "-" + toDate);



	}  // End of Application Program
}
