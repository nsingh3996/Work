import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-show-by-id',
  templateUrl: './show-by-id.component.html',
  styleUrls: ['./show-by-id.component.css']
})
export class ShowByIdComponent implements OnInit {

  customer:Customer;
  constructor(private _customerService:CustomerService,private _router:Router) { }

  ngOnInit() {
    this.customer=this._customerService.getter();
  }

  alertLogOut()
  {
    if(confirm("Do you really want to log out ?"))
    {
      this._router.navigate(['/']);
    }
  }

}
