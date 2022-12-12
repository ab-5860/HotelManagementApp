package com.lcwd.rating.service.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    

    @Autowired
    private RatingService ratingService;


    // create rating

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.create(rating));   
    }


    // get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getRatings());

    }


    // get rating by userId

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
    {

        return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getRatingByUserId(userId));
    }



    // get rating by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getRatingByHotelId(hotelId));
    }



}
