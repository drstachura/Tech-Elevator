package com.techelevator.models;

public class Hotel {

    // data members MUST have names that match the JSON attributes to used with them
    //      if we want the API interface we use to automagically transfer data between
    //      the JSON required and used the API and this JAVA object
    //
    // Not all JSON attributes need to be represented in the POJO
    // We can also have data members not in the JSON
    private int    id;
    private String name;
    private int    stars;
    private int    roomsAvailable;
    private String coverImage;

    public Hotel() {   // Default ctor that does nothing
    }

    // The API interface will be using standard getters/setters for this object
    // That's why we have standard getters/setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n overImage" + coverImage;
    }
}
