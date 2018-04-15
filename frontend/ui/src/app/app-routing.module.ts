import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';

import { CustomerComponent } from '../app/customer/customer.component';
import { RegisterCustomerComponent } from '../app/customer/register-customer.component';

import { LoanComponent } from '../app/loan/loan.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'customer', component: CustomerComponent },
  { path: 'customer/register', component: RegisterCustomerComponent },
  { path: 'customer/register/:id', component: RegisterCustomerComponent },
  { path: 'customer/:id/loan/simulate', component: LoanComponent },

  { path: 'loan/:id', component: LoanComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
