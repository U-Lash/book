import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import "../../../../assets/cache/bottom-8224b2.js";
import {LoginService} from "../../../services/login.service";
import {FileService} from "../../../services/file.service";

declare var startMat: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  @ViewChild('fileInput') inputEl: ElementRef;
  logged: boolean = false;
  size: string;

  constructor(private loginService: LoginService, private fileService: FileService) {
  }

  ngOnInit() {
    startMat();
    this.userLogged();
  }

  userLogged() {
    this.logged = this.loginService.getLogged();
    // console.log(localStorage.getItem('logged'))
    // this.logged=localStorage.getItem('logged');
  }

  upload() {
    let inputEl: HTMLInputElement = this.inputEl.nativeElement;
    let fileCount: number = inputEl.files.length;
    let formData = new FormData();
    if (fileCount > 0) { // a file was selected
      formData.append('pathUrl', 'pdf');
      for (let i = 0; i < fileCount; i++) {
        formData.append('file', inputEl.files.item(i), inputEl.files.item(i).name);
      }
      // formData.append('file', inputEl.files.item(0), inputEl.files.item(0).name);
      this.size = (inputEl.files.item(0).size / 1024 / 1024).toFixed(2)
      this.fileService.uploadFile(formData)
    }
  }
}
