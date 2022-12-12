package com.lcwd.hotel.service.services;

import java.util.List;

import com.lcwd.hotel.service.entities.Hotel;

public interface HotelService {
    

    // create
    Hotel create(Hotel hotel);


    // getall
    List<Hotel> getAll();

    //get single
    Hotel get(String hotelId);

}
