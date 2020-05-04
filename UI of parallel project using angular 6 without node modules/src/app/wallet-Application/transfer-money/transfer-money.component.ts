import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-transfer-money',
  templateUrl: './transfer-money.component.html',
  styleUrls: ['./transfer-money.component.css']
})
export class TransferMoneyComponent implements OnInit {

  customer:Customer;
  customers:Customer[];
  customer2:Customer;
  constructor(private _customerService:CustomerService,private _router:Router) { }
  ngOnInit() {
    this.customer=this._customerService.getter();
    this._customerService.getCustomer().subscribe((customers)=>{
      this.customers=customers;
      console.log(customers);
    },(error)=>{
      console.log(error);
    });
    console.log("Transfer getter: "+this.customer.username + " "+this.customer.amount);
  }

  makeTransfer(account,amount){
    for(let c of this.customers){
      if(c.accountNumber == account){
        console.log("Fetched User To Transfer "+c);
        this.customer2 = c;
        console.log(this.customer2);
        break;
      }
      else{
        console.log("User Not fetched");
      }
    }
    //make transaction
    this.customer.amount = this.customer.amount.valueOf()-amount;
    this.customer2.amount = Number(this.customer2.amount).valueOf()+Number(amount);

    console.log(this.customer.amount + " "+this.customer2.amount);

    //update Transaction array
    this.customer.transaction.push({"transactionId":undefined,"amount":amount,"type":"Sent To "+this.customer2.accountNumber,"userId":this.customer.userId}); 
    this.customer2.transaction.push({"transactionId":undefined,"amount":amount,"type":"Receieved From "+this.customer.accountNumber,"userId":this.customer2.userId}); 

    //update transactions in both the accounts
    this._customerService.makeTransaction(this.customer).subscribe((customer)=>{
      console.log(customer);
    },(error)=>{
      console.log(error);
    })

    this._customerService.makeTransaction(this.customer2).subscribe((customer)=>{
      console.log(customer);
    },(error)=>{
      console.log(error);
    })

    //re route to the Profile Page
    this._router.navigate(['/showById'])

  }
  
}
