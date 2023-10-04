import {Component, Input} from '@angular/core';
import {FuelStrategy} from "../../model/setup/fuel-strategy";
import {ValidateFuelStrategy} from "../../model/validateSetup/validate-fuel-strategy";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-fuel-strategy',
  templateUrl: './fuel-strategy.component.html',
  styleUrls: ['./fuel-strategy.component.css']
})
export class FuelStrategyComponent{
  @Input() fuelStrategyValues: FuelStrategy;
  @Input() validateFuelStrategy: ValidateFuelStrategy;
  fuelStrategyForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();
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
