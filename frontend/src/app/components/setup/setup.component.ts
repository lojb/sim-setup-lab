import {Component} from '@angular/core';
import {SetupValues} from "../../model/setup/setup-values";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ValidateSetup} from "../../model/validateSetup/validate-setup";
import {Tyres} from "../../model/setup/tyres";
import {Electronics} from "../../model/setup/electronics";
import {FuelStrategy} from "../../model/setup/fuel-strategy";
import {MechanicalGrip} from "../../model/setup/mechanical-grip";
import {Dampers} from "../../model/setup/dampers";
import {Aero} from "../../model/setup/aero";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: string = 'tyres';
  setupValues: SetupValues = new SetupValues();
  validator: ValidateSetup;
  carsList: any;
  tracksList: any;
  selectedCar: any;
  selectedTrack: any;
  allSelected: boolean;
  setupForm: FormGroup;

  constructor(private http: HttpClient, setupToLoad?: any) {
    if (!setupToLoad) {
      this.http.get('/api/v1/setup/enums')
        .subscribe((data: any) => {
          this.carsList = data.cars;
          this.tracksList = data.tracks;
        })
    } else {
      this.selectedCar = setupToLoad.carType;
      this.selectedTrack = setupToLoad.selectedTrack;
    }
  }

  toggleSelectedPart(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  startSetup() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    this.http.get(`/api/v1/setup/default?track=${this.transformStringToEnum(this.selectedTrack)}&car=${this.transformStringToEnum(this.selectedCar)}`, {headers})
      .subscribe((setup: any) => {
        this.loadSetup(setup);
      })
    this.allSelected = this.selectedTrack && this.selectedCar;

    this.http.get(`/api/v1/validatesetup/${this.transformStringToEnum(this.selectedCar)}`, {headers})
      .subscribe((validator: any) => {
        this.validator = validator;
      })
  }

  submitSetup() {
    this.setupValues.userId = Number(localStorage.getItem('userId'));
    this.setupValues.carType = this.transformStringToEnum(this.selectedCar);
    this.setupValues.track = this.transformStringToEnum(this.selectedTrack);
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

  loadSetup(setup: any) {
    delete setup.id;
    delete setup.aero.id;
    delete setup.dampers.id;
    delete setup.electronics.id;
    delete setup.fuelStrategy.id;
    delete setup.mechanicalGrip.id;
    delete setup.tyres.id;

    if (setup.setupType === "DEFAULT") {
      delete setup.user;
      setup.name = "";
    }

    this.setupValues = setup;
  }

  public transformEnumToString(input: string): string {
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

  transformStringToEnum(input: string): string {
    const words = input.split(' ');

    const capitalizedWords = words.map(word => {
      return word.toUpperCase();
    });

    return capitalizedWords.join('_');
  }

  handleTyresUpdate(tyres: Tyres) {
    this.setupValues.tyres = tyres;
  }

  handleElectronicsUpdate(electronics: Electronics) {
    this.setupValues.electronics = electronics;
  }

  handleFuelStrategyUpdate(fuelStrategy: FuelStrategy) {
    this.setupValues.fuelStrategy = fuelStrategy;
  }

  handleMechanicalGripUpdate(mechanicalGrip: MechanicalGrip) {
    this.setupValues.mechanicalGrip = mechanicalGrip;
  }

  handleDampersUpdate(dampers: Dampers) {
    this.setupValues.dampers = dampers;
  }

  handleAeroUpdate(aero: Aero) {
    this.setupValues.aero = aero;
  }
}
