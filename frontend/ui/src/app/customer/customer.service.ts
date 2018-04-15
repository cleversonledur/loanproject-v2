
import { Customer } from './customer';

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';
 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class CustomerService {
  
  private http: Http;
  private headers: Headers;
  private options:RequestOptions;

  private customerUrl = 'http://localhost:4200/api/customer/';
  private loanUrl = 'http://localhost:4200/api/loan/';

  constructor(http: Http){
         this.http = http;
  
         this.headers = new Headers();
         this.headers.append('Content-type','application/json');
         this.options = new RequestOptions({ headers: this.headers });
  }

  getCustomers(){
    return this.http.get(this.customerUrl + "all/").map(res => res.json());
  }
  
  deleteCustomer(customer : Customer){
    console.log("URL:" + this.customerUrl + customer.id);
    return this.http.delete(this.customerUrl + customer.id).map(r => r);
  }

  getCustomer(id : string){
    return this.http.get(this.customerUrl + id).map(res => res.json());
  }

  updateCustomer(customer : Customer){
    return this.http.put(this.customerUrl, JSON.stringify(customer),this.options)
        .map(res => res.json());
  }

  addCustomer(customer : Customer){
    console.log(customer);
    return this.http.post(this.customerUrl, JSON.stringify(customer),this.options)
        .map(res => res.json());
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
  
}
