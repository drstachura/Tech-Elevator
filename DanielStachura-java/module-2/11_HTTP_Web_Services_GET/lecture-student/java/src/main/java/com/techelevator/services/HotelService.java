package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    // RestTemplate is a framework for making and managing API calls

    private final String API_BASE_URL;                      //Hold the base URL for the server
    private RestTemplate restTemplate = new RestTemplate(); //Define and instantiate a RestTemplate

    //ctor for the class - receives the base URL for the server and assigns to our data member for holding it
    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;
    }

    // Return all the Hotels from the API server - hotels path - return all the hotels from the server
    public Hotel[] listHotels() {
        // call the API server with the hotels path and have it return a List of Hotel objects
        // getForObjects() method for the RestTemplate class receives a (URL , type of object to be returned)
        // Hotel[].class - we want an Array of Hotel objects returned and Hotel is a class
        // RestTemplate automatically creates objects of the class specified using the standard setters
        //      it expects the data members names in the POJO match the JSON attribute names you want
        //      if they don't, no data is put in the attributes of the object (get null or 0)
        return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
    }

    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "reviews" , Review[].class);
    }

    // Get information for the specific hotelID passed - hotels/:id
    public Hotel getHotelById(int id) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + id , Hotel.class);
    }

    // Get all the reviews from the API for a particular Hotel - hotels/:id/reviews - :id indicates a variable
    public Review[] getReviewsByHotelId(int hotelID) {
        // Construct the URL as a String with the value for the hotelID in the proper place
        // Concatenate the value passed in the URL when calling the API
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews" , Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
