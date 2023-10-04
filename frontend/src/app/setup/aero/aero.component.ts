import {Component, Input, NgModule} from '@angular/core';
import {Aero} from "../../model/setup/aero";
import {ValidateAero} from "../../model/validateSetup/validate-aero";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-aero',
  templateUrl: './aero.component.html',
  styleUrls: ['./aero.component.css']
})

export class AeroComponent {

  @Input() aeroValues: Aero;
  @Input() validateAero: ValidateAero;
  aeroForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm() {
    this.aeroForm = this.formBuilder.group({
      frontRideHeight: [this.aeroValues.frontRideHeight, [
        Validators.required,
        Validators.min(this.validateAero.frontRideHeightMin),
        Validators.max(this.validateAero.frontRideHeightMax)
      ]],
      rearRideHeight: [this.aeroValues.rearRideHeight, [
        Validators.required,
        Validators.min(this.validateAero.rearRideHeightMin),
        Validators.max(this.validateAero.rearRideHeightMax),
      ]],
      splitter: [this.aeroValues.splitter, [
        Validators.required,
        Validators.min(this.validateAero.splitterMin),
        Validators.max(this.validateAero.splitterMax),
      ]],
      rearWing: [this.aeroValues.rearWing, [
        Validators.required,
        Validators.min(this.validateAero.rearWingMin),
        Validators.max(this.validateAero.rearWingMax),
      ]],
      frontBrakeDucts: [this.aeroValues.frontBrakeDucts, [
        Validators.required,
        Validators.min(this.validateAero.frontBrakeDuctsMin),
        Validators.max(this.validateAero.frontBrakeDuctsMax),
      ]],
      rearBrakeDucts: [this.aeroValues.rearBrakeDucts, [
        Validators.required,
        Validators.min(this.validateAero.rearBrakeDuctsMin),
        Validators.max(this.validateAero.rearBrakeDuctsMax),
      ]]
    });
  }
}
