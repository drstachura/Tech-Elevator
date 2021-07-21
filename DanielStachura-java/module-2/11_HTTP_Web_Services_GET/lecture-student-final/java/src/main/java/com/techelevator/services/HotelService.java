package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    // RestTemplate is a framework for making and managing API calls

    private final String API_BASE_URL;                      // Hold the base URL for the server
    private RestTemplate theAPI = new RestTemplate(); // Define and instantiate a RestTemplate

    // constructor to the class - receives the base URL for the server and assigns to our data member for holding it
    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    // return all the Hotels from the API server - hotels path - return all the hotels from the server
    public Hotel[] listHotels() {
        // call the API server with the hotels path and have it return a List of Hotel objects
        // getForObjects() method for the RestTemplate class receives a URL and type of object to be returned
        // Hotel[].class - we want an array of Hotel objects returned and Hotel is a class
        // RestTemplate AUTOMAGICALLY creates objects of the class specified using standard setters
        //              it expects the data member names in the POJO match the JSON attribute names you want
        //              if they don't no data is put in the attributes of the object (null or 0)
        return theAPI.getForObject(API_BASE_URL + "hotels", Hotel[].class);
    }

    public Review[] listReviews() {
        return theAPI.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    // Get information for the specific hotelID passed - path:  hotels/:id
    public Hotel getHotelById(int id) {

        return theAPI.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
    }

    // Get all the reviews from teh API for a particular Hotel - hotels/:id/reviews path - : indicates a variable
    public Review[] getReviewsByHotelId(int hotelID) {
        // Construct the URL as a String with the value for the hotelId in the proper place
        // Concatenate the value passed in the URL when call the API
        return theAPI.getForObject(API_BASE_URL + "hotels/" + hotelID +"/reviews", Review[].class);
    }
    // Get all hotels with a specific star rating - path: hotels?stars=:stars
    // Note: value for stars is being sent via query string
    public Hotel[] getHotelsByStarRating(int stars) {
        return theAPI.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return theAPI.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
    }
}
