import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Dampers} from "../../model/setup/dampers";
import {ValidateDampers} from "../../model/validateSetup/validate-dampers";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Aero} from "../../model/setup/aero";

@Component({
  selector: 'app-dampers',
  templateUrl: './dampers.component.html',
  styleUrls: ['./dampers.component.css']
})

export class DampersComponent implements OnInit{

  @Input() dampersValues: Dampers;
  @Input() validateDampers: ValidateDampers;
  @Output() dataUpdate = new EventEmitter<Dampers>();
  dampersForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();

    this.dampersForm.valueChanges.subscribe((formValue) => {
      this.dampersValues = formValue;
      this.dataUpdate.emit(this.dampersForm.value);
    });
  }

  initializeForm() {
    this.dampersForm = this.formBuilder.group({
      frontLeftBump: [
        this.dampersValues.frontLeftBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontBumpMin),
          Validators.max(this.validateDampers.frontBumpMax),
        ]
      ],
      frontRightBump: [
        this.dampersValues.frontRightBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontBumpMin),
          Validators.max(this.validateDampers.frontBumpMax),
        ]
      ],
      rearLeftBump: [
        this.dampersValues.rearLeftBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearBumpMin),
          Validators.max(this.validateDampers.rearBumpMax),
        ]
      ],
      rearRightBump: [
        this.dampersValues.rearRightBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearBumpMin),
          Validators.max(this.validateDampers.rearBumpMax),
        ]
      ],

      frontLeftFastBump: [
        this.dampersValues.frontLeftFastBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontFastBumpMin),
          Validators.max(this.validateDampers.frontFastBumpMax),
        ]
      ],
      frontRightFastBump: [
        this.dampersValues.frontRightFastBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontFastBumpMin),
          Validators.max(this.validateDampers.frontFastBumpMax),
        ]
      ],
      rearLeftFastBump: [
        this.dampersValues.rearLeftFastBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearFastBumpMin),
          Validators.max(this.validateDampers.rearFastBumpMax),
        ]
      ],
      rearRightFastBump: [
        this.dampersValues.rearRightFastBump,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearFastBumpMin),
          Validators.max(this.validateDampers.rearFastBumpMax),
        ]
      ],

      frontLeftRebound: [
        this.dampersValues.frontLeftRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontReboundMin),
          Validators.max(this.validateDampers.frontReboundMax),
        ]
      ],
      frontRightRebound: [
        this.dampersValues.frontRightRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontReboundMin),
          Validators.max(this.validateDampers.frontReboundMax),
        ]
      ],
      rearLeftRebound: [
        this.dampersValues.rearLeftRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearReboundMin),
          Validators.max(this.validateDampers.rearReboundMax),
        ]
      ],
      rearRightRebound: [
        this.dampersValues.rearRightRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearReboundMin),
          Validators.max(this.validateDampers.rearReboundMax),
        ]
      ],

      frontLeftFastRebound: [
        this.dampersValues.frontLeftFastRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontFastReboundMin),
          Validators.max(this.validateDampers.frontFastReboundMax),
        ]
      ],
      frontRightFastRebound: [
        this.dampersValues.frontRightFastRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.frontFastReboundMin),
          Validators.max(this.validateDampers.frontFastReboundMax),
        ]
      ],
      rearLeftFastRebound: [
        this.dampersValues.rearLeftFastRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearFastReboundMin),
          Validators.max(this.validateDampers.rearFastReboundMax),
        ]
      ],
      rearRightFastRebound: [
        this.dampersValues.rearRightFastRebound,
        [
          Validators.required,
          Validators.min(this.validateDampers.rearFastReboundMin),
          Validators.max(this.validateDampers.rearFastReboundMax),
        ]
      ],
    });
  }
}
