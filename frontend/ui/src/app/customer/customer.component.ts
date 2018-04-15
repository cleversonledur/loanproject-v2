import { Component, OnInit } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {CustomerService} from './customer.service';
import {Customer} from './customer';
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  providers: [CustomerService]
})
export class CustomerComponent implements OnInit {

  customer : Customer = new Customer();
  customerList : Customer[] = new Array();

  deleteCustomer : Customer = new Customer();
  
  customerService : CustomerService;

  constructor(customerService : CustomerService,  private router: Router) {
    this.customerService = customerService;
   }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.customerService.getCustomers().subscribe(
      res => this.customerList = res
    );
  }

  removeCustomer(id : number){
    this.customerList.forEach(c => {
      if(c.id == id)
       this.customerList.splice(this.customerList.indexOf(c),1);
    });
  }

  saveCustomer(){
    if(this.customer.id == undefined){
      this.customerService.addCustomer(this.customer).subscribe(response => {
        this.loadData();
      },
      (erro) => {   
        alert(erro);
      });

   }
   else{

     this.customerService.updateCustomer(this.customer).subscribe(response => {},
    (erro) => {                    
      alert(erro);
    });
   }
  }

  loanSimulate(id : number){
    this.router.navigate(['/customer', id,'loan','simulate']);
  }

  updateCustomer(id : number){
    this.router.navigate(['/customer/register/', id]);
  }
  confirmRemoveCustomer(customer: Customer) {
    let id : number = customer.id;
    if(confirm("Deseja excluir o usuário " + name)) {
      this.customerService.deleteCustomer(customer)
      .subscribe(
        res => this.removeCustomer(id)
      );   

      ;
    }
  }

}
