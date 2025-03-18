package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	private final String COLLECTION_NAME = "restaurants";
	private final String F_CUISINE = "cuisine";


	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// Mongo query:
	// db.restaurants.distinct("cuisine")
	public List<String> getCuisines() {
		// Implementation in here
		List<String> cuisines = mongoTemplate.findDistinct(new Query(), F_CUISINE, COLLECTION_NAME, String.class);
		return cuisines.stream().map(c -> c.replaceAll("/", "_")).collect(Collectors.toList());
	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//  
		/*Query to get restaurants
		 * db.restaurants.find({
				cuisine: "Asian"
			}, {name:1}).sort({name:1})
		 */
	public List<Document> getRestaurantsByCuisine(String cuisine) {
		// Implmementation in here
		return null;	
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  
		
	public Optional<Restaurant> getRestaurant(String name) {
		return null;
		
	}


	// // TODO Task 5
	// // Use this method to insert a comment into the restaurant database
	// // DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// // Write the Mongo native query above for this method
	// //  
	public void addComment(Comment comment) {

	}
	
	// You may add other methods to this class
	

}
