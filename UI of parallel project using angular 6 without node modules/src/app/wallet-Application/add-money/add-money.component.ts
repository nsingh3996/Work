import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
import {Transaction} from '../transaction';
@Component({
  selector: 'app-add-money',
  templateUrl: './add-money.component.html',
  styleUrls: ['./add-money.component.css']
})
export class AddMoneyComponent implements OnInit {

  customer:Customer;
   
  
  constructor(private _customerService:CustomerService,private _router:Router) { }
  ngOnInit() {
    this.customer=this._customerService.getter();
    console.log("Withdraw getter: "+this.customer.username + " "+this.customer.amount);
   
  }
  makeDeposit(amount:Number){
    
    let amount1:Number;
    amount1=Number(this.customer.amount);
    let amount2 = Number(amount)
    amount1 = amount1.valueOf()+amount2;
    //console.log(amount1);
    this.customer.amount= amount1;
 
  this.customer.transaction.push({"transactionId":undefined,"amount":amount,"type":"deposit","userId":this.customer.userId});
  this._customerService.makeTransaction(this.customer).subscribe((customer)=>{
     console.log(customer);
   },(error)=>{
     console.log(error);
   });
   this._router.navigate(['/showById'])
  }
}
