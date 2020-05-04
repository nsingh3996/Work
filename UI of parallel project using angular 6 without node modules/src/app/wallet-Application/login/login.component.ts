import { Component, OnInit ,Inject} from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Customer } from '../customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
import { Transaction } from '../transaction';
import { FormGroup, FormControl, FormBuilder, Validators } from "@angular/forms";
import { FormsModule } from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  accId: number = Date.now();
  name:"";
  pan:"";
  aadhar="";
  phone="";
  amount=0;
  username="";
  password="";

  private customers:Customer[];
  private customer:Customer;
  constructor(private _customerService:CustomerService,private _router:Router) { }


  ngOnInit() {
      this._customerService.getCustomer().subscribe((customers)=>{
        console.log(customers);
        this.customers=customers;
      },(error)=>{
        console.log(error)
      })

      this.customer= this._customerService.getter();


  }

  getUrl()
  {
    return "url('./assets/personal-bank.jpg')";
  }

  validationForm(username,password){
    let count=0;
      for(let c of this.customers){
        console.log(c);
        if(c.username==username && c.password==password){
          this._router.navigate(['/showById']);
          this._customerService.setter(c);
          count++;
          break;
        }
        else{
          this._router.navigate(['/']);
          console.log("Invalid Details");
        }
      }
      if(count==0)
      {
        alert("Invalid Credentials. Please enter valid username and password.")
      }
  }

  showLogin(signup,login){
      signup.style.display="none";
      login.style.display="block";
  }

  showSignup(signup,login){
    signup.style.display="block";
    login.style.display="none";
  }

  makeAccount(accountNumber,name,pan,aadhar,phone,amount,username,password){
    let valid:boolean
    let id:Number
    for(let c of this.customers){
        id = c.userId;
    if(c.username == username){
      console.log("Username Already Taken");
      alert("Username Already Taken");
      valid = false;
      break;
    }

    else{
    valid=true;
    }
  }
  if(valid==true){
    console.log(accountNumber + " "+name+" "+pan+" "+aadhar+" "+phone+" "+amount+" "+username+ " "+password);
    
    this.customer={"userId":undefined,
    "accountNumber":accountNumber,
    "customerName":name,
    "panNumber":pan,
    "aadharNumber":aadhar,
    "phoneNo":phone,
    "amount":amount,
    "username":username,
    "password":password,
    "transaction":[
      {
        "transactionId":undefined,
        "amount":undefined,
        "type":undefined,
        "userId":undefined
      }
    ]
  }

console.log(this.customer);

     this._customerService.addCustomer(this.customer).subscribe((customer)=>{
       console.log(customer);
     },(error)=>{
       console.log(error);
     })
   
     this._router.navigate(['/'])
     alert("Account Created. Return to Login Page");
    }
    else{
      console.log("Not Inserted")
    }



}
}
