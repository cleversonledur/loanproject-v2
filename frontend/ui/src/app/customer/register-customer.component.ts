import { Component, OnInit } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { CustomerService } from './customer.service';
import { Customer } from './customer';
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./customer.component.css'],
  providers: [CustomerService]
})
export class RegisterCustomerComponent implements OnInit {

  customer: Customer = new Customer();
  customerList: Customer[] = new Array();

  deleteCustomer: Customer = new Customer();

  customerService: CustomerService;

  constructor(customerService: CustomerService, private router: Router,
    private route: ActivatedRoute) {
    this.customerService = customerService;

    this.route.params.subscribe(params => {
      if (params["id"] != undefined) {
        this.customerService.getCustomer(params['id']).subscribe(res => this.customer = res);
      }
    });
  }

  ngOnInit() {

    this.loadData();
  }

  loadData() {
    this.customerService.getCustomers().subscribe(res => this.customerList = res);
  }

  defineRisk() {
    console.log("ok");
    if (this.customer.income <= 2000) {
      this.customer.riskType = 'C';
      return;
    }

    if (this.customer.income > 2000 && this.customer.income <= 8000) {
      this.customer.riskType = 'B';
      return;
    }

    if (this.customer.income > 8000) {
      this.customer.riskType = 'A';
      return;
    }
  }

  saveCustomer() {
    if (this.customer.id == undefined) {
      this.customerService.addCustomer(this.customer).subscribe(response => {
        this.loadData();
        this.router.navigate(['/customer']);
      },
        (erro) => {
          alert(erro);
        });
    }
    else {
      this.customerService.updateCustomer(this.customer).subscribe(response => {
        this.loadData();
        this.router.navigate(['/customer']);
      },
        (erro) => {
          alert(erro);
        });
    }
  }

  clickMethod(customer: Customer) {
    if (confirm("Deseja excluir o usuário " + name)) {
      this.customerService.deleteCustomer(customer)
        .subscribe(() => this.loadData());


    }
  }

}
