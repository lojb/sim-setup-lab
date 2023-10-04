import {Component, Input} from '@angular/core';
import {Electronics} from "../../model/setup/electronics";
import {ValidateElectronics} from "../../model/validateSetup/validate-electronics";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-electronics',
  templateUrl: './electronics.component.html',
  styleUrls: ['./electronics.component.css']
})
export class ElectronicsComponent{
  @Input() electronicsValues: Electronics;
  @Input() validateElectronics: ValidateElectronics;

  electronicsForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm() {
    this.electronicsForm = this.formBuilder.group({
      tractionControl: [
        this.electronicsValues.tractionControl,
        [
          Validators.required,
          Validators.min(this.validateElectronics.tractionControlMin),
          Validators.max(this.validateElectronics.tractionControlMax),
        ]
      ],
      abs: [
        this.electronicsValues.abs,
        [
          Validators.required,
          Validators.min(this.validateElectronics.absMin),
          Validators.max(this.validateElectronics.absMax),
        ]
      ],
      ecuMap: [
        this.electronicsValues.ecuMap,
        [
          Validators.required,
          Validators.min(this.validateElectronics.ecuMapMin),
          Validators.max(this.validateElectronics.ecuMapMax),
        ]
      ],
      telemetryLaps: [
        this.electronicsValues.telemetryLaps,
        [
          Validators.required,
          Validators.min(this.validateElectronics.telemetryLapsMin),
          Validators.max(this.validateElectronics.telemetryLapsMax),
        ]
      ],
    });
  }
}
