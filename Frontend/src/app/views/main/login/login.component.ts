import {Component, OnInit} from '@angular/core';
import {jquery} from '../../../../assets/ajax/libs/jquery/3.2.1/jquery.min.js';
import "../../../../assets/cache/bottom-8224b2.js";
import {LoginService} from "../../../services/login.service";
import {Router} from "@angular/router";
import {User} from "../../../dtos/user";

declare var startMat: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  loggedUser = new User();
  failed: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {
  }

  ngOnInit() {
    startMat();
    this.user.accountType = "User";
  }

  authenticateLogin(): void {
    this.loginService.authenticateLogin(this.user).subscribe(
      (result) => {
        this.loggedUser = result;
        if (this.loggedUser.authenticate == true) {
          this.failed = false;
          this.loginService.setLogged(true)
          // localStorage.setItem('logged','true');
          localStorage.clear();
          localStorage.setItem("login", "logged");
          localStorage.setItem("userName", this.loggedUser.userName);
          localStorage.setItem("accountType", this.loggedUser.accountType);
          this.router.navigate(['/main/dashboard']);
        } else {
          this.failed = true;
          this.loginService.setLogged(false);
          // localStorage.setItem('logged','false');
        }
      }
    );
  }
}
