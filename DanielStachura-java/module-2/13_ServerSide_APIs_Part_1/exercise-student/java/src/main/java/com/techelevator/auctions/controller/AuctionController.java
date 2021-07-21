package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

//@RequestMapping BEFORE the Controller class
//Set the DEFAULT BASE PATH FOR ALL PATHS SPECIFIED IN OTHER @RequestMapping
//
//for example: if you want a controller for the path: "/auctions"      - @RequestMapping(""),method=....)
//             if you want a controller for the path: "/auctions/{id}" - @RequestMapping("/{id}"),method=....)
@RequestMapping("/auctions")    //This controller will handle all /auctions paths

public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

//------------------Write your controllers here-----------------------------------------//

// List() - List<Auction> list();
    @RequestMapping(path="" , method=RequestMethod.GET)
    public List<Auction> listAllAuctions(@RequestParam(required=false ) String title_like
                                        ,@RequestParam(required=false ) Double currentBid_lte) {

        System.out.println("/auctions: listAllAuctions for HTTP GET from the server");

        if (currentBid_lte == null) currentBid_lte = 0D;
        if (title_like == null) title_like = "";


        if (currentBid_lte > 0 && !title_like.equals("")) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        if (currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }
        if (!title_like.equals("")) {
            return dao.searchByTitle(title_like);
        }
            return dao.list();
        }

// Get() - Auction get(int id);
    @RequestMapping(path="/{id}" , method=RequestMethod.GET)
    public Auction getAuctionByID(@PathVariable int id){
        System.out.println("/auctions: getAuctionByID " + id + " for HTTP GET from the server");
        return dao.get(id);
    }

// Create() - Auction create(Auction auction);
    @RequestMapping(path="" , method=RequestMethod.POST)
    public Auction createNewAuction(@RequestBody Auction anAuction){
        System.out.println("/auctions: createNewAuction for HTTP POST from the server");
        return dao.create(anAuction);
    }

// Search by title - List<Auction> searchByTitle(String title_like);
 /*   @RequestMapping(path="/filter" , method=RequestMethod.GET)
        public List<Auction> searchByTitle(@RequestParam(required = false) String title_like) {
            //       System.out.println("/auctions: listAllAuctions for HTTP GET from the server");

            List<Auction> matchTitles = new ArrayList<>();
            List<Auction> auctions = dao.list();

            for (Auction auction : auctions) {
                if (title_like != null) {
                    if (auction.getTitle().toLowerCase().contains(title_like.toLowerCase())) {
                        matchTitles.add(auction);
                    }
                }
            }
                return matchTitles;

        }*/






}//END
