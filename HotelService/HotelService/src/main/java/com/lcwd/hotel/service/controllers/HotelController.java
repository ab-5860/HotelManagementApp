package com.lcwd.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = this.hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }


    // get single
    @GetMapping("/{Id}")
    public ResponseEntity<Hotel> get(@PathVariable("Id") String Id)
    {

        return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.get(Id));
    }

    // all users
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.hotelService.getAll());
    }


}
