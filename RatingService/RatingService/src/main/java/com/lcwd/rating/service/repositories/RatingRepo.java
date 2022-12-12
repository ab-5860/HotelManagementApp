package com.lcwd.rating.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.rating.service.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating,String>{
    

    // custom finder methods


    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);


}
