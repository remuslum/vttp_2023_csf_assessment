import { Component, inject, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant-service';
import { Observable } from 'rxjs';

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

  ngOnInit(): void {
    this.cuisines$ = this.restaurantSvc.getCuisineList()
  }

  protected getRestaurants(c:string){
    
  }
}
