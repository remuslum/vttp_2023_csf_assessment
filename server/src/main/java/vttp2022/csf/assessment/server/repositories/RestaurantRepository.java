package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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
	private final String F_NAME = "name";
	private final String F_ID = "_id";

	private final String C_COMMENTS = "comments";
	private final String F_R_ID = "restaurantId";
	private final String F_TEXT = "text";
	private final String F_RATING = "rating";



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
		return cleanUpList(cuisines, "/", "_");
	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	// db.restaurants.distinct("name",{cuisine:"${cuisine}"})
	public List<String> getRestaurantsByCuisine(String cuisine) {
		// Implmementation in here
		Criteria cuisineCriteria = Criteria.where(F_CUISINE).is(cuisine);
		Query query = Query.query(cuisineCriteria);
		query.fields().include(F_NAME).exclude(F_ID);
		List<String> restaurants = mongoTemplate.findDistinct(query,F_NAME, COLLECTION_NAME, String.class);
		return cleanUpList(restaurants, "/", "_");	
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	// db.restaurants.find({name:"Ajisen Ramen"}) 
		
	public Optional<Restaurant> getRestaurant(String name) {
		Query query = Query.query(Criteria.where(F_NAME).is(name));
		Optional<Document> restaurantDoc = Optional.ofNullable(mongoTemplate.findOne(query,Document.class,COLLECTION_NAME));
		return restaurantDoc.map(r -> {
			return Restaurant.createFromDoc(r);
		});
		
	}


	// // TODO Task 5
	// // Use this method to insert a comment into the restaurant database
	// // DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// // Write the Mongo native query above for this method
	// // db.comments.insertOne(${comment})
	public void addComment(Comment comment) {
		Document d = new Document();
		d.append(F_R_ID, comment.getRestaurantId()).append(F_NAME, comment.getName()).append(F_TEXT, comment.getText())
		.append(F_RATING, comment.getRating());

		mongoTemplate.insert(d, C_COMMENTS);
	}
	
	// You may add other methods to this class
	
	public List<String> cleanUpList(List<String> stringList, String oldString, String newString){
		return stringList.stream().map(c -> c.replaceAll("/", "_")).collect(Collectors.toList());
	}
}
