import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { Headers, Http } from '@angular/http';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';


import { CustomerComponent } from './customer/customer.component';
import { RegisterCustomerComponent } from './customer/register-customer.component';

import { LoanComponent } from './loan/loan.component';
import { CustomerService } from './customer/customer.service';
import { HttpClientModule } from '@angular/common/http';
import { LoanService } from './loan/loan.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    CustomerComponent,
    RegisterCustomerComponent,
    LoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    FormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [
    CustomerService,
    LoanService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
