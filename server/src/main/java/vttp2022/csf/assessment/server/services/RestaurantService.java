package vttp2022.csf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	// @Autowired
	// private MapCache mapCache;


	// TODO Task 2 
	// Use the following method to get a list of cuisines 
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public String getCuisines() {
		List<String> cuisines = restaurantRepo.getCuisines();
		JsonArrayBuilder cuisinesArray = Json.createArrayBuilder();
		cuisines.forEach(cuisinesArray::add);
		return cuisinesArray.build().toString();
		
	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public String getRestaurantsByCuisine(String cuisine) {
		List<String> restaurants = restaurantRepo.getRestaurantsByCuisine(cuisine);
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		restaurants.forEach(arrayBuilder::add);
		return arrayBuilder.build().toString();
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public Optional<Restaurant> getRestaurant(String name) {
		return restaurantRepo.getRestaurant(name);
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public void addComment(Comment comment) {
		restaurantRepo.addComment(comment);
	}
	//
	// You may add other methods to this class
	
}
