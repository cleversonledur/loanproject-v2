import { Input } from '@angular/core';

export class Loan{

    @Input() public presentValue : number;
    @Input() public months : number;
    @Input() public riskType : string;
    @Input() public ratePerMonth : number;
    @Input() public total : number;
    @Input() public monthlyPayment : number;
    @Input() public interest : number;

    constructor(){

    }

    
}