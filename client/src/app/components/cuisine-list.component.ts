import { Component, inject, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant-service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit {

	// TODO Task 2
	// For View 1
  cuisines$ !: Observable<string>
  restaurantSvc = inject(RestaurantService)
  router = inject(Router)

  ngOnInit(): void {
    this.cuisines$ = this.restaurantSvc.getCuisineList()
  }

  protected getRestaurants(c:string){
    this.router.navigate([`${c}/restaurants`])
  }
}
