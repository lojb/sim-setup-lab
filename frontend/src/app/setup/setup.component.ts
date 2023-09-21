import {Component} from '@angular/core';
import {SetupValues} from "../model/setup/setup-values";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: string = 'tyres';
  setupValues = new SetupValues();
  carsList: any;
  tracksList: any;
  selectedCar: any;
  selectedTrack: any;
  allSelected: boolean;

  constructor(private http: HttpClient) {
    this.http.get('/api/v1/setup/enums')
      .subscribe((data: any) => {
        console.log(data)
        this.carsList = data.cars;
        this.tracksList = data.tracks;
      })
  }

  ToggleSelectedPart(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  SubmitSetup() {
    this.setupValues.userId = Number(localStorage.getItem('userId'));
    this.setupValues.carType = this.TransformStringToEnum(this.selectedCar);
    this.setupValues.track = this.TransformStringToEnum(this.selectedTrack);
    this.setupValues.setupType = 'CUSTOM';
    console.log(this.setupValues);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    this.http.post(`/api/v1/setup`, this.setupValues, {headers})
      .subscribe((setup: any) => {
        console.log(setup)
      });
  }

  StartSetup() {

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    this.http.get(`/api/v1/setup/default?track=${this.TransformStringToEnum(this.selectedTrack)}&car=${this.TransformStringToEnum(this.selectedCar)}`, {headers})
      .subscribe((setup: any) => {
        this.LoadDefaultSetup(setup);
      })
    this.allSelected = this.selectedTrack && this.selectedCar;
  }

  LoadDefaultSetup(setup: any) {
    delete setup.id;
    delete setup.aero.id;
    delete setup.dampers.id;
    delete setup.electronics.id;
    delete setup.fuelStrategy.id;
    delete setup.mechanicalGrip.id;
    delete setup.tyres.id;
    delete setup.user;
    setup.name = "";
    this.setupValues = setup;
  }

  TransformEnumToString(input: string): string {
    const words = input.split('_');

    const capitalizedWords = words.map(word => {
      if (word.length === 0) {
        return '';
      }

      if (word.length <= 3) {
        return word;
      }

      const firstChar = word.charAt(0).toUpperCase();
      const restOfWord = word.slice(1).toLowerCase();
      return firstChar + restOfWord;
    });

    return capitalizedWords.join(' ');
  }

  TransformStringToEnum(input: string): string {
    const words = input.split(' ');

    const capitalizedWords = words.map(word => {
      return word.toUpperCase();
    });

    return capitalizedWords.join('_');
  }


}
