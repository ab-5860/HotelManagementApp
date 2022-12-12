package com.lcwd.rating.service.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.exceptions.ResourceNotFoundException;
import com.lcwd.rating.service.repositories.RatingRepo;
import com.lcwd.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{


    @Autowired
    private RatingRepo ratingRepo;


    @Override
    public Rating create(Rating rating) {
        
        String RandomId = UUID.randomUUID().toString();
        rating.setRatingId(RandomId);
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        
        return this.ratingRepo.findByHotelId(hotelId);
    }

    
    



}
