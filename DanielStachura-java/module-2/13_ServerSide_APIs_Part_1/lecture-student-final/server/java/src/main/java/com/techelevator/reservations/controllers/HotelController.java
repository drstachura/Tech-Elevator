package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// This is a Controller for URL calls to the server
//
// Coordinate requests from a client (View)  to process data managed by the DAO (Model)
//
// Spring Boot automagically converts JSON to Java objects (deserialize) when receiving a request
//                               and  Java objects to JSON (serialize)   when returning to client

@RestController  // This tells the server there are methods in this class to handle URL paths
public class HotelController {

    // Define references for any DAOs we are using
    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    // ctor for this class - initialize member data when object of this class is instantiated
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();  // Instantiate new HotelDAO and assign to reference
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);  // Instantiate a new Reservation DAO and assign to reference
        // Since the Reservation DAO needs a HotelDAO, we send it one
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // A controller method to handle a URL path given to the server
    // @RequestMapping - Annotation to identify the path and HTTP request this method will hanlde
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)  // handle the /hotels path for a HTTP GET request
    public List<Hotel> list() {   // return a List of Hotel objects and receive no parameters
        System.out.println("Hello from the list() in the Controller");
        return hotelDAO.list();   // return whatever the hotelDAO list() send us back
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    // handle an HTTP GET for the URL path: /hotels/id - id is a variable in the URL the path
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)  // {id} - a path variable called id is expected
    public Hotel get(@PathVariable int id) {  // @PathVariable says get the id from the path
        // and store it in an int called id
        System.out.println("/hotel/" + id + " path received from server");  // log how you got here and what was sent
        return hotelDAO.get(id);  // return whatever the hotelDAO get(id) method returns
    }

    // Write a controller to add a reservation to our Resource
    //         using the path: /hotels/id/reservations - /hotels/1/reservations will add a reservation for hotel id 1
    //                                                                           to our resource
    //
    // The data for reservation to be added is expected to be a Reservation object in the body of an HTTP POST
    // so... we need the Reservation POJO in this project - we have one!
    //       we need a method in the Reservation DAO to add a Reservation
    //                 we have one: Reservation create(Reservation reservation, int hotelID);
    //       we need to use @PathVariable to get the hotel id from the path
    //       we need to use @RequestBody to get the Reservation object out of the request body
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    //                                        path var name  pgm-vr-name
    public Reservation addAReservation(@PathVariable("id") int hotelId   // get the path path variable called id
                                       //    and store in int called hotelId
            , @RequestBody Reservation aReservation) {// Instantiate a Reservationfrom the request body
        System.out.println("/hotel/" + hotelId + "/reservations for an HTTP POST received from server");

        // Instantiate a new reservation from the one returned from ReservationDAO
        Reservation theReservation = reservationDAO.create(aReservation, hotelId);

        return theReservation;  // return the reservation from the DAO
    }

    // Write a Controller to return a specific reservation for a hotel
    // CANNOT DO THIS - THERE IS NOT DAO METHOD TO HANDLE IT

    // Write a Controller to return all reservations for a hotel
    // Reservation DAO method: List<Reservation> findByHotel(int hotelID);
    // Path:  /hotels/{id}/reservations
    //        this is the same path for adding a Reservation
    //        It's OK, because this time the path is for an HTTP GET
    //
    // The path/HTTP Request combination must be unique within the controller

    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> findByHotel(@PathVariable("id") int hotelId) {
        System.out.println("/hotel/" + hotelId + "/reservations for an HTTP GET received from server");
        return reservationDAO.findByHotel(hotelId);
    }

    // Write a controller to return all reservations
    // Path: /reservations
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        System.out.println("/reservations for an HTTP GET received from server");
        return reservationDAO.findAll();
    }

    /**
     * /hotels/filter?state=oh&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city) {

        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = list();

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

}
