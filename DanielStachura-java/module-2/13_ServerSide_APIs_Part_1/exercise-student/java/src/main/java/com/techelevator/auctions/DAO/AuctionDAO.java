package com.techelevator.auctions.DAO;

import com.techelevator.auctions.model.Auction;

import java.util.List;

public interface AuctionDAO {

    List<Auction> list();

    Auction get(int id);

    Auction create(Auction auction);

    List<Auction> searchByTitle(String title_like);

    List<Auction> searchByPrice(double currentBid_lte);

        //LOOK AT LECTURE FINAL FOR THIS//
    List<Auction> searchByTitleAndPrice(String title, double currentBid);
}
