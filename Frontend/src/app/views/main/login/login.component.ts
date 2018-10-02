import { Component, OnInit } from '@angular/core';
import {jquery} from '../../../../assets/ajax/libs/jquery/3.2.1/jquery.min.js';
import "../../../../assets/cache/bottom-8224b2.js";

declare var startMat: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    startMat();
  }

}
