import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit {

  route$!: Subscription;
  cuisine!: string;
  restaurants$!: Observable<string>;

  activatedRoute = inject(ActivatedRoute)
  restaurantSvc = inject(RestaurantService)
  router = inject(Router)

	
	// TODO Task 3
	// For View 2
  ngOnInit(): void {
    this.cuisine = this.activatedRoute.snapshot.params['cuisine']
    this.restaurants$ = this.restaurantSvc.getRestaurantsByCuisine(this.cuisine)
  }

  getRestaurantDetails(name:string){
    this.router.navigate([`${this.cuisine}/restaurants/${name}`])
  }
}
