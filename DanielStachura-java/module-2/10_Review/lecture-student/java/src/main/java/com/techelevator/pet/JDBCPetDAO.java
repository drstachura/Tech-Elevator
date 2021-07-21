package com.techelevator.pet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

// ************************** Concrete Class to implement the code for the DAO *******************

/*
TABLE_NAME	COLUMN_NAME	   TYPE_NAME	IS_NULLABLE	        COLUMN_DEF
    Pet	       petid		serial	        NO	        nextval('pet_petid_seq'::regclass)
    Pet	       name		    varchar	        NO	            (null)
    Pet	       pettype		int4	        NO	            (null)
    Pet	       ownerid		int4	        NO	            (null)
    Pet	       whenadded    timestamp	    NO	        CURRENT_TIMESTAMP
    Pet	       lastupdate	timestamp	    NO	        CURRENT_TIMESTAMP
*/

public class JDBCPetDAO implements PetDAO {

    //Object to interact with Spring DAO
    private JdbcTemplate theDataBase;

    //ctor to receive the datasource and assign to a JdbcTemplate object
    public JDBCPetDAO(DataSource theDataSource) {
        theDataBase = new JdbcTemplate(theDataSource);
    }


    @Override
    public List<Pet> getAllPets() {
        // Define the object to be returned
        List<Pet> thePets = new ArrayList();

        // Define the SQL statement to access the database
        String getAllPetsSQL = "SELECT * FROM Pet";

        // Run the SQL and store the result
        SqlRowSet resultsFromSelect = theDataBase.queryForRowSet(getAllPetsSQL);

        // Copy the data from the SQL results into our List that we are returning
        while (resultsFromSelect.next()) {    // loop while there is a row in the result and position to the next row
            thePets.add(mapRowToPet(resultsFromSelect));
        }

        // Return the object created to be returned
        return thePets;
    }

    @Override
    public Pet getAPet(long petid) {
        return null;
    }

    @Override
    public void addPet(Pet aPet) {

    }

    @Override
    public Pet updatePet(Pet aPet) {
        return null;
    }

    // Helper method to copy the data from a row in a result to a Pet object and return the Pet object
    // make this private so users can't call it, ONLY class members
    private Pet mapRowToPet(SqlRowSet theRow) {
        // Define an object to be returned
        Pet aPet = new Pet();
        aPet.setName(theRow.getString("name"));     // copy the name column from the result to the Pet object
        aPet.setPetID(theRow.getLong("petid"));
        aPet.setOwnerId(theRow.getInt("ownerid"));
        aPet.setPetType(theRow.getInt("pettype"));
        aPet.setLastUpdated(theRow.getTimestamp("lastupdate").toLocalDateTime());
        aPet.setWhenAdded(theRow.getTimestamp("whenadded").toLocalDateTime());
        return aPet;
    }
}
