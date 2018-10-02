import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainComponent } from './views/main/main.component';
import { LoginComponent } from './views/main/login/login.component';
import {AppRoutingModule} from "./app-routing.module";
import { SignUpComponent } from './views/main/sign-up/sign-up.component';
import { DashboardComponent } from './views/main/dashboard/dashboard.component';
import { BookDetailsComponent } from './views/main/book-details/book-details.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    SignUpComponent,
    DashboardComponent,
    BookDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
