import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit {

  route$!: Subscription;
  cuisine!: string;
  restaurants: string[]=[];

  constructor(private restaurantSvc: RestaurantService, private activatedRoute: ActivatedRoute, private router: Router) { }
	
	// TODO Task 3
	// For View 2
  ngOnInit(): void {

  }
}
