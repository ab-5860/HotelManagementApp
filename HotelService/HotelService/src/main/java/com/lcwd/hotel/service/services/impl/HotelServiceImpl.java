package com.lcwd.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.service.repositories.HotelRepo;
import com.lcwd.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{


    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return this.hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        
        List<Hotel> list = this.hotelRepo.findAll();
        return list;
    }

    @Override
    public Hotel get(String hotelId) {
        
        return this.hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found"));

        
    }
    
}
