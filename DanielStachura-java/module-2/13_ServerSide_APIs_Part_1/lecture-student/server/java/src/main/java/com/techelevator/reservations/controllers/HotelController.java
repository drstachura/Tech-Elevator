package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is a Controller for URL calls to the server
//
// Coordinate requests from a client(View) to process data managed by the DAO(Model)
//
// Spring Boot automagically converts JSON to Java Objects (deserialize) when receiving a request
//                        and Java Objects to JSON (serialize) when returning an object

@RestController // This tells the server there are methods in this class to handle URL Paths
public class HotelController {

    // Define references for any DAOs we are using
    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    // ctor for this class - initialize member data when an object is instantiated
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO(); // Instantiate a new HotelDAO and assign to reference
        this.reservationDAO = new MemoryReservationDAO(hotelDAO); // Instantiate a new reservationDAO and assign to reference
                                                                  //Since the reservationDAO needs a HotelDAO, we send it one
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // A controller method to handle a URL path given to the server
    // @RequestMapping - Annotation to identify the path and HTTP request this method will handle
    @RequestMapping(path="/hotels", method=RequestMethod.GET) //handle the /hotels path for a HTTP GET request
    public List<Hotel> list() {     //return a List of Hotel Objects and receive no parameters

        System.out.println("Hello from the list() in the Controller");

        return hotelDAO.list();     //return whatever the hotelDAO list() method send us back
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    // handle a HTTP GET for the URL path: /hotels/id - id is a variable in the URL path
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)  // {id} - a path variable called id is expected
    public Hotel get(@PathVariable int id) {    // @PathVariable says get the id from the path
                                                //  and store it in an int called id
        System.out.println("/hotel/" + id + " path received from the server");  //Good idea to log how you got here and what was sent

        return hotelDAO.get(id);    // return whatever the hotelDAO get(id) method returns
    }

    // Write a controller to add a reservation to our Resource(something on our computer)
    //  using the path: /hotels/id/reservations = /hotels/1/reservations will add a reservation for hotel id 1 to our resource
    // The data for reservation to be added is expected to be a Reservation object in the body of an HTTP POST
    // so...we need the Reservation POJO in this project - we have one! (in models)
    //      we need a method in the ReservationDAO to add a Reservation - we have one! (DAO -> ReservationDAO)
    //                 = Reservation create(Reservation reservation, int hotelID);
    //      we need to use @PathVariable to get the hotel id from the path
    //      we need to use @RequestBody to get the Reservation object out of the request body
    @RequestMapping(path="/hotels/{id}/reservations" , method=RequestMethod.POST)
    public Reservation add(@PathVariable int id                         //get the path variable called id, store it in int id
                          ,@RequestBody Reservation aReservation) {     //instantiate a Reservation from the request body

        System.out.println("/hotels/" + id + " reservations for HTTP POST received from the server");

        // Instantiate a new reservation from the one returned from the ReservationDAO
        Reservation theReservation = reservationDAO.create(aReservation, id);   //create the object and return the object
                                                                                // vs return in one statement - see above returns
        return theReservation;  //return the reservation from the DAO
    }
//--------------------------------------------------------------------------------------------------------------------//
    // Write a Controller to return a specific reservation for a hotel
    // CANNOT DO THIS - THERE IS NOT A DAO METHOD TO HANDLE IT

    // Write a Controller to return all reservations for a hotel
    //  Reservation DAO method: List<Reservation> findByHotel(int hotelID);
    // Path: /hotels/{id}/reservations
    //      this is the same path for adding a Reservation
    //          it's OK, because this time the path is for a HTTP GET
    //
    // The path/HTTP Request combination must be unique within the controller
    @RequestMapping(path="/hotels/{id}/reservations" , method=RequestMethod.GET)
    public List<Reservation> findByHotel(@PathVariable("id") int hotelID) {
        System.out.println("/hotels/" + hotelID + " reservations for HTTP GET received from the server");
        return reservationDAO.findByHotel(hotelID);
    }

    //Write a Controller to return all the reservations
    // Path: /reservations
    @RequestMapping(path="/reservations" , method=RequestMethod.GET)
    public List<Reservation> getAllReservations(){
        System.out.println("/reservations for HTTP GET received from the server");
        return reservationDAO.findAll();
    }

}//End
