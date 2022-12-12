package com.lcwd.user.service.services.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entites.Hotel;
import com.lcwd.user.service.entites.Rating;
import com.lcwd.user.service.entites.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public User saveUser(User user) {
		
		// generate unique userId
		
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> users = userRepository.findAll();
		
		return users;
	}

	@Override
	public User getUser(String userId) {
		

		// get user from database with the help of user repository

		User user =  userRepository.findById(userId).orElseThrow(
												()-> new ResourceNotFoundException("User with given id is not found on server"+userId));

		// fetch rating of the above user from RATING SERVICE
		// http://localhost:8088/ratings/users/fe349687-c631-408f-8820-bf40d7014642


		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
		logger.info("{}",ratingsOfUser);


		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
				// api call to hotel service to get the hotel
				// http://localhost:8087/hotels/61c904b2-fe2f-4371-bb15-bc0b04c68475

				ResponseEntity<Hotel> forEntity = 
				restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

				Hotel hotel = forEntity.getBody();
				logger.info("response status code : {}",forEntity.getStatusCode());
				// set the hotel to rating
				rating.setHotel(hotel);
				// return the rating
				return rating;
		}).collect(Collectors.toList());	

		user.setRatings(ratingList);
		return user;
		
	}
	
	
}

