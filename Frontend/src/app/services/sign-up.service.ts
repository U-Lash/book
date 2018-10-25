import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/index";
import {User} from "../dtos/user";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {NewUser} from "../dtos/new-user";

const URL = "/api/v1/user";

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private router: Router, private http: HttpClient) { }

  signUp(user: NewUser): Observable<User> {
    return this.http.post<User>(environment.backend_url + URL + "/signUp", user);
  }
}
