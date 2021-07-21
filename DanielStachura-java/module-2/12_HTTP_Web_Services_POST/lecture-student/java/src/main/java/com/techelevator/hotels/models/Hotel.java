package com.techelevator.hotels.models;

public class Hotel {

// Variable names must match JSON attributes to match them
    private int id;
    private String name;
    private int stars;
    private int roomsAvailable;
    private String coverImage;

    public Hotel() {
    }

    public Hotel(int id, String name, int stars, int roomsAvailable) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.roomsAvailable = roomsAvailable;
        this.coverImage = "default-cover-image.png";
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

// Getters only as we do not want the users to change the data from the API
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
}
