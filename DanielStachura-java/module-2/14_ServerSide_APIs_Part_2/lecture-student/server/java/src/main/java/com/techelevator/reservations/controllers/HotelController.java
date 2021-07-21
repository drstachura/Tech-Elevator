package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO       theHotelResource;
    private ReservationDAO theReservationResource;

    // ctor is accepting the DAO objects as parameters rather than instantiate them itself
<<<<<<< HEAD
    // Where do the objects come from for the ctor? We did not instantiate them and send to ctor?
    //      Who did instantiate them and send to ctor?
    //          Spring Dependency Injection did it for us!
    // Spring Dependency Injection automagically instantiates objects and pass them to the ctor
    //You must specify the @Component annotation in a class you want to be considered for Dependency Injection(DI)
    // The concrete classes for the DAO must have the @Component annotation so Spring DI will instantiate them
    //    and pass the new objects to the ctor
=======
    // Where do the objects come from for the ctor?  WE did not instantiate them and send to ctor?
    //       Who did instantiate them and send to ctor?
    //       Spring Dependency Injection did it for us!
    // Spring Dependency Injection (DI) automagcally instantiate objects and pass them to ctor
    // You must specify the @Component annotation in a class you want to be considered for DI
    // The concrete classes for the DAO must have @Component annotation so Spring DI will instant them
    //              and pass the new objects to the ctor
>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f
    public HotelController(HotelDAO theHotelResource, ReservationDAO theReservationResource) {
        this.theHotelResource       = theHotelResource;
        this.theReservationResource = theReservationResource;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path="/hotels", method=RequestMethod.GET)
    public List<Hotel> list() {
        logAPICall("GET  - /hotels");           // Log path to server log
        return theHotelResource.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        logAPICall("GET  - /hotels/"+ id);          // Log path to server log
        return theHotelResource.get(id);
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservations() {
        logAPICall("GET  - /reservations");         // Log path to server log
        return theReservationResource.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @exception ReservationNotFoundException if reservation does not exist.
     * @return a single reservation
     */
    @RequestMapping(path="reservations/{id}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        logAPICall("GET  - /reservations/" + id);   // Log path to server log
        return theReservationResource.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelID
     * @return all reservations for a given hotel
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelID) throws HotelNotFoundException {
        logAPICall("GET  - /hotels/" + hotelID + "/reservations");   // Log path to server log
        return theReservationResource.findByHotel(hotelID);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     * @param hotelID
     */
<<<<<<< HEAD
    // If you want the server to use any Validation Annotation you have in the POJO:
    //
    //  1. you need to include @Valid in the method parameter list before the @RequestBody for the object


    @ResponseStatus(HttpStatus.CREATED) // Set the HTTP Status code when the method terminates(200 CREATED)
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation
                                     ,@PathVariable("id") int hotelID)
            throws HotelNotFoundException { // throws says i know this Exception might happen
=======
    // If you want the server to use any Validation Annotations you have in the POJO
    //    include @Valid in the method parameter list before the @RequestBody for the object
    //
    @ResponseStatus(HttpStatus.CREATED)   // Set the HTTP Status code when the method terminates
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation
                                     ,@PathVariable("id") int hotelID)
            throws HotelNotFoundException {  // throws says I know this Exception might happen
>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f
        logAPICall("POST - /hotels/" + hotelID + "/reservations");   // Log path to server log
        return theReservationResource.create(reservation, hotelID);
    }

    /**
<<<<<<< HEAD
     * Update an existing reservation
     *
     *  /reservations/{id}  = Standard RESTful path for an UPDATE
     *
     *  Handle a HTTP PUT for an update
     *
     * @param reservation - from RequestBody for a HTTP PUT
     * @param id            - from PathVariable
     * @return the updated reservation
     *
     */
     @RequestMapping(path="/reservations/{id}" , method=RequestMethod.PUT)
     public Reservation updateReservation(@Valid @RequestBody Reservation reservation
                                         ,@PathVariable int id) throws ReservationNotFoundException {
         // Call the DAO to update the resource and return the updated reservation from the DAO
         return theReservationResource.update(reservation, id);
     }

    /**
     *  delete and existing reservation
     *
     *  /reservations/{id}  = Standard RESTful path for an DELETE
     *
     * @param id - PathVariable
     *
     *  nothing to return
     *
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)  // return the NO_CONTENT after the delete
    @RequestMapping(path="/reservations/{id}" , method=RequestMethod.DELETE)
    public void deleteRes(@PathVariable int id) throws ReservationNotFoundException {
        theReservationResource.delete(id);
    }


=======
     * update an existing reservation
     *
     * /reservations/{id}   = Standard RESTful path for an update
     *
     * Handle an HTTP PUT for an update
     *
     * @param aReservation - from Request Body for a an HTTP PUT
     * @param id           - from Path Variable
     * @return the updated Reservation
     */
     @RequestMapping(path="/reservations/{id}",method=RequestMethod.PUT)
     public Reservation anyNameYouWant(@Valid @RequestBody Reservation aReservation
                                      ,@PathVariable int id) throws ReservationNotFoundException {
         //  Call the DAO to update the resource and return the updated reservation from the DAO
         return theReservationResource.update(aReservation, id);
     }

    /**
     *  delete an existing reservation
     *
     *  /reservations/{id}       = Standard RESTful path for an delete
     *
     * @param id - from PathVariable
     *
     *  Nothing to return
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)  // return the No_CONTENT after the delete
    @RequestMapping(path="/reservations/{id}",method=RequestMethod.DELETE)
    public void YouPickAnyNameServerDoesNotCare(@PathVariable int id) throws ReservationNotFoundException {
        theReservationResource.delete(id);
    }

>>>>>>> b7638781d2ec5328c943a75f8fb406129d216b3f
    /**
     * /hotels/filter?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path="/hotels/filter", method=RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state
                                           ,@RequestParam(required = false) String city) {

        // Log path to server log with parameters omitting optional parameters if missing
        logAPICall("GET  - /hotels/filter?state=" + state + ((city != null) ? "&city=" + city : ""));

        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = theHotelResource.list() ;   // Get all the hotels from the Hotel resource
        // return hotels that match state
        for (Hotel hotel : hotels) {

            // if city was passed we don't care about the state filter
            if (city != null) {
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            }
        }
        return filteredHotels;
    }

    /****************************************************************************************************
     * Helper method to Write a message with a time stamp to the server log\
     *
     *  @param message
     ***************************************************************************************************/
    public void logAPICall(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
        String timeNow = now.format(formatter);
        System.out.println(timeNow + "-" + message);
    }
}
