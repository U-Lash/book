import {Component, OnInit} from '@angular/core';
import {NewUser} from "../../../dtos/new-user";
import {SignUpService} from "../../../services/sign-up.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  newUser: NewUser = new NewUser();

  constructor(private signUpService: SignUpService, private router: Router) {
  }

  ngOnInit() {
  }

  signUp() {
    console.log(this.newUser)
    this.signUpService.signUp(this.newUser).subscribe(
      (result) => {
        this.router.navigate(['/main/login']);
      }
    );
  }
}
