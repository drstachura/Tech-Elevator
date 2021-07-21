package com.techelevator.city;  // same package as the POJO

// DAO INterface for table we want to access

import java.util.List;

// If one wants to be known as a CityDAO it MUST implement these methods
public interface CityDAO {

	// NOTICE: Objects are used in the DAO methods instead of individual variables
	//         except for find and delete methods
	//         When saving or updating data to the database - objects are used NOT variables

	// Save the given City object to the database
	public void save(City newCity);

	// Return a City object from the database for the id specified
	public City findCityById(long id);

	// Return all the City objects from the database for the given countryCode
	public List<City> findCityByCountryCode(String countryCode);

	// Return all the City objects from the database for the given district (state)
	public List<City> findCityByDistrict(String district);

	// Update the City data in the database using the City object passed
	public void update(City city);

	// Delete the city data in the database for the given id
	public void delete(long id);
}
