import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
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
  form!: FormGroup
  name!: string;
  route$!: Subscription;
  restaurant!: Restaurant;
  comment!: Comment;


  constructor(private restaurantSvc: RestaurantService, private activatedRoute: ActivatedRoute, private fb: FormBuilder, private router: Router) {  }


  ngOnInit():void {

  }



}
