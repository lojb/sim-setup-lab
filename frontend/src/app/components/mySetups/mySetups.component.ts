import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SetupValues} from "../../model/setup/setup-values";

@Component({
  selector: 'app-user',
  templateUrl: './mySetups.component.html',
  styleUrls: ['./mySetups.component.css']
})
export class MySetupsComponent {

  setupList: Array<SetupValues>;

  constructor(private http: HttpClient) {

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    this.http.get(`/api/v1/setup/user/${localStorage.getItem("userId")}`, {headers})
      .subscribe((data: any) => {
        this.setupList = data;
        console.log(this.setupList);
      })
  }
}
