import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
import {Transaction} from '../transaction';
@Component({
  selector: 'app-withdraw-money',
  templateUrl: './withdraw-money.component.html',
  styleUrls: ['./withdraw-money.component.css']
})
export class WithdrawMoneyComponent implements OnInit {

  customer:Customer;
   
  
  constructor(private _customerService:CustomerService,private _router:Router) { }
  ngOnInit() {
    this.customer=this._customerService.getter();
    console.log("Withdraw getter: "+this.customer.username + " "+this.customer.amount);
   
  }
  makeWithdrawal(amount:number){
    if(this.customer.amount>amount)
    {
      this.customer.amount= this.customer.amount.valueOf()-amount;
 
  this.customer.transaction.push({"transactionId":undefined,"amount":amount,"type":"withdraw","userId":this.customer.userId});
  this._customerService.makeTransaction(this.customer).subscribe((customer)=>{
     console.log(customer);
   },(error)=>{
     console.log(error);
   });
   this._router.navigate(['/showById'])
  }
  else
  {
    console.log("Insufficient Balance");
  }
}
}