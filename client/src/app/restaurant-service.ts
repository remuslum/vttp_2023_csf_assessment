import { HttpClient } from '@angular/common/http'
import { inject, Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { Restaurant, Comment } from './models'

@Injectable()
export class RestaurantService {

	restaurant!: Restaurant;
	httpClient = inject(HttpClient)

	// TODO Task 2 
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getCuisineList():Observable<string> {
		// Implememntation in here
		return this.httpClient.get<string>("/api/cuisines");

	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getRestaurantsByCuisine(cuisine: string):Observable<string> {
		return this.httpClient.get<string>("/api/" + cuisine + "/restaurants")
	}
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE

	//change back rmb
	public getRestaurant(name: string) {
		// Implememntation in here

	}

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE
	public postComment(comment: Comment) {
		// Implememntation in here


	}
}
