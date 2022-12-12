package com.lcwd.rating.service.services;

import java.util.List;

import com.lcwd.rating.service.entities.Rating;

public interface RatingService {
    

    // create
    Rating create(Rating rating);

    // get all
    List<Rating> getRatings();

    // get all by UserId
    List<Rating> getRatingByUserId(String userId);


    // get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);


}
