import { Component, OnInit } from '@angular/core';
import "../../../../assets/cache/bottom-8224b2.js";

declare var startMat: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    startMat();
  }

}
