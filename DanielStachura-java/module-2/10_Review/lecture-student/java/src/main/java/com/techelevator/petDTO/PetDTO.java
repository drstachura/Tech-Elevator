package com.techelevator.petDTO;

import com.techelevator.petowner.JDBCOwnerDAO;
import com.techelevator.petowner.Owner;
import com.techelevator.petowner.OwnerDAO;
import com.techelevator.pet.JDBCPetDAO;
import com.techelevator.pet.Pet;
import com.techelevator.pet.PetDAO;

import javax.sql.DataSource;


/********************************************************************************************
 * A DTO is a Data Transfer Object
 *
 * It's used when multiple objects need to be transfered between processes
 *
 * We want to be able to send a user a Pet object and an Owner object
 *
 *
 *
 ********************************************************************************************/



public class PetDTO {
    // define the objects we need to send in the DTO
    Pet aPet;
    Owner anOwner;

    //ctor to create a PetDTO - it needs to know the id of the Pet you want
    public PetDTO(long thePetId, DataSource theDataSource) {

        //Define the DAO object for access to PetJDBCDAO
        PetDAO thePetTable = new JDBCPetDAO(theDataSource);
        OwnerDAO theOwnerTable = new JDBCOwnerDAO();

        // we need to find the Pet for the PetId that was passed to us in the database - use JDBCPetDAO to get it
        aPet = thePetTable.getAPet(thePetId); // Get the Pet info the user wanted
        anOwner = theOwnerTable.getOwnerForPet(aPet.getPetID()); // Get the Owner info for the Pet the user wanted
    }

    public Pet getaPet() {
        return aPet;
    }

    public Owner getAnOwner() {
        return anOwner;
    }
}
