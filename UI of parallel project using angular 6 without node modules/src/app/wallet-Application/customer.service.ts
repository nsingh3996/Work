import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators'; 
import { Observable, throwError, from } from 'rxjs';
import {Customer} from './customer';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl:String = 'http://localhost:8088/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers})
  private customer:Customer;
  constructor(private _http:Http) { }

  getCustomer(){
    return this._http.get(this.baseUrl+"/customers",this.options).pipe(map((response: Response) => response.json()))
    .pipe(catchError(this.errorHandler));
  }

  addCustomer(customer:Customer){
    return this._http.post(this.baseUrl+"/addCustomer",JSON.stringify(customer),this.options).pipe(map((response: Response) => response.json()))
    .pipe(catchError(this.errorHandler));
  }

 

  upateCustomer(customer:Customer){
    return this._http.put(this.baseUrl+"/updateCustomer",JSON.stringify(customer),this.options).pipe(map((response: Response) => response.json()))
    .pipe(catchError(this.errorHandler));
  }

  makeTransaction(customer:Customer){
    return this._http.put(this.baseUrl+"/makeTransaction",JSON.stringify(customer),this.options).pipe(map((response: Response) => response.json()))
    .pipe(catchError(this.errorHandler));
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");  
    }

  setter(customer:Customer){
    this.customer=customer;
  }
  getter(){
    return this.customer;
  }
}


