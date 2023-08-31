import {Component} from '@angular/core';
import {SetupValues} from "../model/setup/setup-values";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment.development";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: string | undefined;
  setupValues = new SetupValues();

  constructor(private http: HttpClient) {

  }

  ToggleSelectedPart(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  SubmitSetup() {
    this.setupValues.user = localStorage.getItem('userId');
    console.log(this.setupValues)

    /*const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
      });

    this.http.post(`${environment.backend}/api/v1/setup`, this.setupValues, {headers})
      .subscribe((setup: any) => {
        console.log(setup)
      });*/
  }
}
