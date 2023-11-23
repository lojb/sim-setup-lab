import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FuelStrategy} from "../../../model/setup/fuel-strategy";
import {ValidateFuelStrategy} from "../../../model/validateSetup/validate-fuel-strategy";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Aero} from "../../../model/setup/aero";

@Component({
  selector: 'app-fuel-strategy',
  templateUrl: './fuel-strategy.component.html',
  styleUrls: ['./fuel-strategy.component.css']
})
export class FuelStrategyComponent implements OnInit{
  @Input() fuelStrategyValues: FuelStrategy;
  @Input() validateFuelStrategy: ValidateFuelStrategy;
  @Output() dataUpdate = new EventEmitter<FuelStrategy>();
  fuelStrategyForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();

    this.fuelStrategyForm.valueChanges.subscribe((formValue) => {
      this.fuelStrategyValues = formValue;
      this.dataUpdate.emit(this.fuelStrategyForm.value);
    });
  }

  initializeForm() {
    this.fuelStrategyForm = this.formBuilder.group({
      fuel: [
        this.fuelStrategyValues.fuel,
        [
          Validators.required,
          Validators.min(this.validateFuelStrategy.fuelMin),
          Validators.max(this.validateFuelStrategy.fuelMax),
        ]
      ],
      tyreType: [
        this.fuelStrategyValues.tyreType,
        [
          Validators.required
        ]
      ],
      frontBrakes: [
        this.fuelStrategyValues.frontBrakes,
        [
          Validators.required,
          Validators.min(this.validateFuelStrategy.brakesMin),
          Validators.max(this.validateFuelStrategy.brakesMax),
        ]
      ],
      rearBrakes: [
        this.fuelStrategyValues.rearBrakes,
        [
          Validators.required,
          Validators.min(this.validateFuelStrategy.brakesMin),
          Validators.max(this.validateFuelStrategy.brakesMax),
        ]
      ],
    });
  }
}
