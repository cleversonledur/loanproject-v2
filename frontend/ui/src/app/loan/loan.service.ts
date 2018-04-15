import { Loan } from './loan';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';
 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class LoanService {
  
  private http: Http;
  private headers: Headers;
  private options:RequestOptions;

  private loanUrl = 'http://localhost:4200/api/loan/';

  constructor(http: Http){
         this.http = http;
  
         this.headers = new Headers();
         this.headers.append('Content-type','application/json');
         this.options = new RequestOptions({ headers: this.headers });
  }

  calculateLoan(loanRequest : Loan){
    return this.http.post(this.loanUrl + 'calculate', JSON.stringify(loanRequest),this.options)
        .map(res => res.json());
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
  
}
