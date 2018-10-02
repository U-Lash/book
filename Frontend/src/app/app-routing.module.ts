import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {MainComponent} from "./views/main/main.component";
import {LoginComponent} from "./views/main/login/login.component";
import {DashboardComponent} from "./views/main/dashboard/dashboard.component";
import {SignUpComponent} from "./views/main/sign-up/sign-up.component";
import {BookDetailsComponent} from "./views/main/book-details/book-details.component";

const appRoutes: Routes = [
  {
    path: "main", component: MainComponent,
    children: [
      {path: "dashboard", component: DashboardComponent},
      {path: "login", component: LoginComponent},
      {path: "signup", component: SignUpComponent},
      {path: "book-details", component: BookDetailsComponent},
    ]
  },
  {path: "", pathMatch: "full", redirectTo: "/main/dashboard"},
]

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {useHash: true})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}
