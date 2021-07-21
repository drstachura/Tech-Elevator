package com.techelevator.api.review.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Employee {
	// Tell Spring to automatically convert JSPN dates to LocalDates
	// LocalDate is a Java specific data type
	// RestTemplate works with any programming language
	// So when we use a programming language specific data type like LocalDate (or BigDecimal)
	//    we need to provide a way to have the JSON that goes between us and server convert to the
	//    language specific data type
	@JsonDeserialize(using = LocalDateDeserializer.class) // Spring provided process to convert JSON string to LocalDate
	@JsonSerialize(using = LocalDateSerializer.class)     // Spring provided process to convert JSON string to LocalDate

	private Long employeeId;
	private Long departmentId;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private char gender;
	private LocalDate hireDate;
	
	public Long getId() {
		return employeeId;
	}
	public void setId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Use a Spring provided process to convert a Local to a String with the format we want
	//     when Spring take an object and serializes into JSON for API calls
	//          we need/can tell it what format we want LocalDate to be as a String
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String toString() {
		return lastName + ", " + firstName;
	}
}
