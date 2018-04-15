import { Input } from '@angular/core';

export class Customer{
    
    @Input() public id : number;
    @Input() public name : string;
    @Input() public income : number;
    @Input() public riskType : string;
    @Input() public address : string;

    constructor(){

    }

    
}