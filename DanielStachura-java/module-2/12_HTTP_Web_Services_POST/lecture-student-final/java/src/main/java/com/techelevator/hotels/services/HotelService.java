package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String         BASE_URL;
  private final RestTemplate   theAPI  = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation - given a String delimiter value with the Reservation info
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
    // It's always a good idea to make sure we received an object when we are called
    //      to avoid a NullPointerException when we use the object
    if (newReservation == null) {
      System.out.println("Missing Reservation information - cannot continue attempt to add new Reservation");  // We may want to add this to the ConsoleService
       return null;
    }

    // Now that we know we have information for a new Reservation, let's make one and add it to server resource

    // Instantiate a Reservation object using the helper method
    Reservation aReservation = makeReservation(newReservation);

    //  We need to do a HTTP POST to add to a server resource
    //  An HTTP POST requires headers to describe the data being sent
    //                        and the data to be added in body of the request

    // The HttpHeaders class will create header for an HTTP request
    HttpHeaders theHeaders = new HttpHeaders();  // Define an object to hold the header info for request
    theHeaders.setContentType(MediaType.APPLICATION_JSON);  // Include in the headers that we sending JSON data
                                                            // MediaType is a group of valid content types for headers

    // We need to create a properly formatted request object for the API call
    // The HttpEntity class will create a properly formatted request for use
    HttpEntity anEntity = new HttpEntity(aReservation, theHeaders); // Create the response as an HttpEntity object
                                                                    // with data and headers to packaged into the request

    // Now that we have a properly formatted request, we can call the server using our RestTemplate object
    // the postForObject() RestTemplate method will issue an HTTP Post to the URL and return an object from the call
    // the API should be adding the primary key to the object (just like in DAO and Relational Data Base)
    //                   so we want the object with the API assigned primary key so we can return it

    //                    postForObject(     url                 , request , class-of-object-to-be-returned);
    try {
      aReservation = theAPI.postForObject(BASE_URL + "reservations", anEntity, Reservation.class);

    } catch (RestClientResponseException exceptionObject) {
      console.printError(exceptionObject.getRawStatusCode() + " : " + exceptionObject.getStatusText());
    } catch (ResourceAccessException exceptionObject) {
      console.printError(exceptionObject.getMessage());
    }
    return aReservation;  // Return the Reservation Object created from the String passed to us
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param newReservationString
   * @return
   */
  public Reservation updateReservation(String newReservationString) {
    // Lets be sure we have data passed to us
    if (newReservationString == null) {
      System.out.println("Unable to update reservations, no new data sent");  // Shoudl add this to ConsoleService
      return null;
    }

    //  We need to do a HTTP PUT to update a server resource
    //  An HTTP PUT requires headers to describe the data being sent
    //                        and the data to be updated in body of the request

    // Create a reservation object to send to the API
    Reservation aReservation = makeReservation(newReservationString);

    // Create the request headers with the type of data we are sending
    HttpHeaders theHeaders = new HttpHeaders();
    theHeaders.setContentType(MediaType.APPLICATION_JSON);

    // Create a properly formatted request with the data to send and the request headers
    HttpEntity aRequest = new HttpEntity(aReservation, theHeaders);

    // Call the API using the request and receiving nothing since by standard, nothing is returned from a PUT
    //  Path for API update:   reservations/:id - we need to add the key for resource to be updated
    try {
      theAPI.put(BASE_URL + "reservations/" + aReservation.getId(), aRequest);

    } catch (RestClientResponseException exceptionObject) {
      console.printError(exceptionObject.getRawStatusCode() + " : " + exceptionObject.getStatusText());
    } catch (ResourceAccessException exceptionObject) {
      console.printError(exceptionObject.getMessage());
    }
    return aReservation;  // Return the updated Reservation object
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    // path to API for a delete is: reservations/:id - :id is the id to delete
    try {
      theAPI.delete(BASE_URL + "reservations/" + id);
    } catch (RestClientResponseException exceptionObject) {
      console.printError(exceptionObject.getRawStatusCode() + " : " + exceptionObject.getStatusText());
    } catch (ResourceAccessException exceptionObject) {
      console.printError(exceptionObject.getMessage());
    }
  }

  /******************************** */
  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */
  /******************************** */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    // It's good practice to always check for exceptions from RestTemplate calls
    //
    // Only two exceptions thrown by RestTemplate
    //
    //  RestClientResponseException - error in the HTTP Request
    //                                the HTTP status code and message text are available in the Exception object
    //
    //  ResourceAccessException - error getting to the server
    //                            NO HTTP status code since it's generated by teh server
    //                            There is message text available in the Exception object
    //
    try {
      hotels = theAPI.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {   // If there is an HTTP request error...
      // handles request error exceptions thrown by rest template and contains status codes
      // getRawStatusCode() method in the Exception object returns the status code (401, 404, etc) from the HTTP request
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());  // display the status code and message
                                                                               //     using the ConsoleService
    } catch (ResourceAccessException ex) {       // If there is an error getting to the server
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage());      // Display the message using the ConsoleService
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = theAPI.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = theAPI.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = theAPI.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = theAPI.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  // Helper method to instantiate and return a Reservation object
  //    from a comma, delimited string comma containing:
  //
  //      Hotel ID, Full Name,  Checkin Date, Checkout Date, Number of Guests
  //Example: 1    , John Smith, 10/10/2020  , 10/14/2020   , 2
  //

  private Reservation makeReservation(String newReservationString) {
    String[] parsed = newReservationString.split(",");   // Split the parts of the String into it's parts based on ,

    // invalid input - if exactly 6 values are not provided in the string
    if (parsed.length < 5 || parsed.length > 6) {   // id there are less than 5 or more 6 elements in the parsed array
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {  // if an id was not provided, generate one and add it to the parsed array
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);  // Java provided method to copy an array
      System.arraycopy(parsed, 0, withId, 1, 5);   // Java provided method to copy an array
      parsed = withId;
    }

    // instantiate a new reservation object using the values, with spaces trimmed, in parsed array and return it
    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
