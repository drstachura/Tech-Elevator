package com.techelevator.city;  // DAO components are in their own package

// POJO (Model Object) for the table we want to access

public class City {
	// data members of  the class that correspond to columns in the table
	private Long   id;          // serial in table
	private String name;        // charater varying(64) in table
	private String countryCode; // charcter(3) in table
	private String district;    // charater varying(64) in table
	private int    population;  // integer in table



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", name='" + name + '\'' +
				", countryCode='" + countryCode + '\'' +
				", district='" + district + '\'' +
				", population=" + population +
				'}';
	}
}
