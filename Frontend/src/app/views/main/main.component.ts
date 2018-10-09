import {Component, OnInit} from '@angular/core';
import {jquery} from '../../../assets/ajax/libs/jquery/3.2.1/jquery.min.js';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private router: Router) {
    // loginService.mainCompo.subscribe((value) => {
    //   this.setSignButtonText(value);
    // });
  }

  ngOnInit() {
    // if (localStorage.getItem('login') != undefined) {
    //
    // }
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/main/dashboard']);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('login') != undefined;
  }

}
