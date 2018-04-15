import { Component, OnInit } from '@angular/core';
import { Loan } from './loan';
import { CustomerService } from '../customer/customer.service';
import { LoanService } from './loan.service';

import { Customer } from '../customer/customer';

import { ActivatedRoute, Router } from "@angular/router";


@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  loan : Loan = new Loan();
  customer : Customer = new Customer();
  simulated : boolean = false;

  constructor(
    private customerService: CustomerService,
    private loanService: LoanService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (params["id"] != undefined) {
        this.customerService.getCustomer(params['id']).subscribe(res => this.customer = res);
      }
    });
  }

  simulateLoan(){
    this.loan.riskType = this.customer.riskType;
    this.loanService.calculateLoan(this.loan).subscribe(
      res => {
        this.loan = res;
        this.simulated = true;
      }
    );
    
  }


  

}
