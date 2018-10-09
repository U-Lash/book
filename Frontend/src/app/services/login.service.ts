import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {User} from "../dtos/user";
import {Observable, Subject} from "rxjs/index";
import {environment} from "../../environments/environment";

const URL = "/api/v1/user";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // mainCompo: Subject<string> = new Subject<string>();

  constructor(private router: Router, private http: HttpClient) { }

  authenticateLogin(user: User): Observable<User> {
    return this.http.post<User>(environment.backend_url + URL + "/authenticate", user);
  }
}
