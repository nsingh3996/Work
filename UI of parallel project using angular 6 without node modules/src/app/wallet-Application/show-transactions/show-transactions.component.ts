import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-show-transactions',
  templateUrl: './show-transactions.component.html',
  styleUrls: ['./show-transactions.component.css']
})
export class ShowTransactionsComponent implements OnInit {

  customer:Customer;
  constructor(private _customerService:CustomerService,private _router:Router) { }
  ngOnInit() {
    this.customer=this._customerService.getter();
    console.log("Transaction getter: "+this.customer.username + " "+this.customer.amount);
   
  }

}
