import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer.component';
import { RegisterCustomerComponent } from './register-customer.component';

import { CustomerService } from './customer.service';


@NgModule({
  imports: [
    CommonModule
  ],
  providers:[
    CustomerService
  ],
  declarations: [
    CustomerComponent,
    RegisterCustomerComponent
  ],
  exports: [
    CustomerComponent
  ]
})
export class CustomerModule { }
