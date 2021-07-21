package com.techelevator.pet;

//****************************** POJO for the Pet table ********************************************

/*
TABLE_NAME	COLUMN_NAME	  TYPE_NAME	    IS_NULLABLE	    COLUMN_DEF
    Pet	       petid		serial	    NO	        nextval('pet_petid_seq'::regclass)
    Pet	       name		    varchar	    NO	            (null)
    Pet	       pettype		int4	    NO	            (null)
    Pet	       ownerid		int4	    NO	            (null)
    Pet	       whenadded    timestamp	NO	        CURRENT_TIMESTAMP
    Pet	       lastupdate	timestamp	NO	        CURRENT_TIMESTAMP
*/


import java.time.LocalDateTime;
import java.util.Objects;

public class Pet {
// Member Variables
    private long petId;
    private String name;
    private int petType;
    private int ownerId;
    private LocalDateTime whenAdded;
    private LocalDateTime lastUpdated;

// Get/Set
    public long getPetID() {
        return petId;
    }

    public void setPetID(long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetType() {
        return petType;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(LocalDateTime whenAdded) {
        this.whenAdded = whenAdded;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

// toString()
    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petId +
                ", name='" + name + '\'' +
                ", petType=" + petType +
                ", ownerId=" + ownerId +
                ", whenAdded=" + whenAdded +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

// equals() - don't always need this
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return getPetID() == pet.getPetID() && getPetType() == pet.getPetType() && getOwnerId() == pet.getOwnerId() && getName().equals(pet.getName()) && getWhenAdded().equals(pet.getWhenAdded()) && getLastUpdated().equals(pet.getLastUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPetID(), getName(), getPetType(), getOwnerId(), getWhenAdded(), getLastUpdated());
    }

} //END
