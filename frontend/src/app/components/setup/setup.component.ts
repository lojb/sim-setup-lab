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
import {RequestService} from "../../service/request.service";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  requestService: RequestService;
  selectedSetupPart: string = 'tyres';
  setupValues: SetupValues = new SetupValues();
  validator: ValidateSetup;
  carsList: Array<string>;
  tracksList: Array<string>;
  selectedCar: any;
  selectedTrack: any;
  allSelected: boolean;

  constructor() {
    this.requestService.getEnums()
      .subscribe((data: any) => {
        this.carsList = data.cars;
        this.tracksList = data.tracks;
      })
  }

  toggleSelectedPart(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  startSetup() {
    this.requestService.getDefaultSetup(this.transformStringToEnum(this.selectedTrack), this.transformStringToEnum(this.selectedCar))
      .subscribe((setup: any) => {
        this.loadSetup(setup);
      })

    this.allSelected = this.selectedTrack && this.selectedCar;

    this.requestService.getValidator(this.transformStringToEnum(this.selectedCar))
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

    this.requestService.postSetup(this.setupValues)
      .subscribe((setup: any) => {
        console.log(setup)
      });
  }

  loadSetup(setup: SetupValues) {
    delete setup.aero.id;
    delete setup.dampers.id;
    delete setup.electronics.id;
    delete setup.fuelStrategy.id;
    delete setup.mechanicalGrip.id;
    delete setup.tyres.id;

    if (setup.setupType === "DEFAULT") {
      delete setup.id;
      delete setup.userId;
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
