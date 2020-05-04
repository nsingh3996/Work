import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customer:Customer;
  
  constructor(private _customerService:CustomerService,private _router:Router) { }

  ngOnInit() {
    this.customer=this._customerService.getter();
    console.log("Update customer getter: "+this.customer.username);
  }

  updateDetails(){
    this._customerService.upateCustomer(this.customer).subscribe((customer)=>{
      console.log(customer);
    },(error)=>{
      console.log(error);
    })
    this._router.navigate(['/showById'])
  }



}
