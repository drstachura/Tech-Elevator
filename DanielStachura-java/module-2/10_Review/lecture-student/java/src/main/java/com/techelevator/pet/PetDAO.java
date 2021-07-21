package com.techelevator.pet;

//******************************** Interface *************************************************

/*
TABLE_NAME	COLUMN_NAME	  TYPE_NAME	    IS_NULLABLE	    COLUMN_DEF
    Pet	       petid		serial	    NO	        nextval('pet_petid_seq'::regclass)
    Pet	       name		    varchar	    NO	            (null)
    Pet	       pettype		int4	    NO	            (null)
    Pet	       ownerid		int4	    NO	            (null)
    Pet	       whenadded    timestamp	NO	        CURRENT_TIMESTAMP
    Pet	       lastupdate	timestamp	NO	        CURRENT_TIMESTAMP
*/

import java.util.List;

public interface PetDAO {

    // Retrieve all Pets
    List<Pet> getAllPets();

    // Get a specific Pet
    Pet getAPet(long petid);

    // Add a Pet
    void addPet(Pet aPet);

    // Update a Pet
    Pet updatePet(Pet aPet);


}// END
