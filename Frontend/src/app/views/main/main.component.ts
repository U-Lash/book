import {Component, OnInit} from '@angular/core';
import {jquery} from '../../../assets/ajax/libs/jquery/3.2.1/jquery.min.js';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  signButtonText = "Sign out";

  constructor() {
  }

  ngOnInit() {

  }

  isLoggedIn(): boolean {
    return this.signButtonText == "Sign out";
  }

}
