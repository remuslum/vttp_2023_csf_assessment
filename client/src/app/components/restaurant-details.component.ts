import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Restaurant, Comment } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
	
	// TODO Task 4 and Task 5
	// For View 3
  name!: string;
  restaurant!: Restaurant;
  comment!: Comment;
  form !: FormGroup

  restaurantSvc = inject(RestaurantService)
  activatedRoute = inject(ActivatedRoute)
  fb = inject(FormBuilder)
  router = inject(Router)

  ngOnInit():void {
    this.name = this.activatedRoute.snapshot.params['name']
    this.restaurantSvc.getRestaurant(this.name).subscribe({
      next : (data) => {
        this.restaurant = {
          restaurantId : data.restaurant_id,
          name : data.name,
          cuisine : data.cuisine,
          address : data.address,
          coordinates : data.coordinates
        }
      }
    })
    this.form = this.createForm()
  }

  createForm():FormGroup {
    return this.fb.group({
      name : this.fb.control<string>('',[Validators.minLength(3)]),
      rating : this.fb.control<string>('',[Validators.min(1),Validators.max(5)]),
      text : this.fb.control<string>('',[Validators.required])
    })
  }

  isFormInvalid():boolean {
    return this.form.invalid
  }

  submitForm():void {
    const formValue = this.form.value
    const comment:Comment = {
      name : formValue.name,
      rating : formValue.rating,
      restaurantId : this.restaurant.restaurantId,
      text : formValue.text
    }
    this.restaurantSvc.postComment(comment).subscribe({
      next : (data) => this.router.navigate(["/"]),
      error : (error) => console.error(error)
    })
    
  }

}
