import {Component, Input} from '@angular/core';
import {Tyres} from "../../model/setup/tyres";
import {ValidateTyres} from "../../model/validateSetup/validate-tyres";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-tyres',
  templateUrl: './tyres.component.html',
  styleUrls: ['./tyres.component.css']
})
export class TyresComponent{
  @Input() tyresValues: Tyres;
  @Input() validateTyres: ValidateTyres;
  tyresForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm() {
    this.tyresForm = this.formBuilder.group({
      frontLeftTyrePressure: [
        this.tyresValues.frontLeftTyrePressure,
        [
          Validators.required,
          Validators.min(this.validateTyres.tyrePressureMin),
          Validators.max(this.validateTyres.tyrePressureMax),
        ]
      ],
      frontRightTyrePressure: [
        this.tyresValues.frontRightTyrePressure,
        [
          Validators.required,
          Validators.min(this.validateTyres.tyrePressureMin),
          Validators.max(this.validateTyres.tyrePressureMax),
        ]
      ],
      rearLeftTyrePressure: [
        this.tyresValues.rearLeftTyrePressure,
        [
          Validators.required,
          Validators.min(this.validateTyres.tyrePressureMin),
          Validators.max(this.validateTyres.tyrePressureMax),
        ]
      ],
      rearRightTyrePressure: [
        this.tyresValues.rearRightTyrePressure,
        [
          Validators.required,
          Validators.min(this.validateTyres.tyrePressureMin),
          Validators.max(this.validateTyres.tyrePressureMax),
        ]
      ],

      frontLeftCamber: [
        this.tyresValues.frontLeftCamber,
        [
          Validators.required,
          Validators.min(this.validateTyres.frontCamberMin),
          Validators.max(this.validateTyres.frontCamberMax),
        ]
      ],
      frontRightCamber: [
        this.tyresValues.frontRightCamber,
        [
          Validators.required,
          Validators.min(this.validateTyres.frontCamberMin),
          Validators.max(this.validateTyres.frontCamberMax),
        ]
      ],
      rearLeftCamber: [
        this.tyresValues.rearLeftCamber,
        [
          Validators.required,
          Validators.min(this.validateTyres.rearCamberMin),
          Validators.max(this.validateTyres.rearCamberMax),
        ]
      ],
      rearRightCamber: [
        this.tyresValues.rearRightCamber,
        [
          Validators.required,
          Validators.min(this.validateTyres.rearCamberMin),
          Validators.max(this.validateTyres.rearCamberMax),
        ]
      ],

      frontLeftToe: [
        this.tyresValues.frontLeftToe,
        [
          Validators.required,
          Validators.min(this.validateTyres.frontToeMin),
          Validators.max(this.validateTyres.frontToeMax),
        ]
      ],
      frontRightToe: [
        this.tyresValues.frontRightToe,
        [
          Validators.required,
          Validators.min(this.validateTyres.frontToeMin),
          Validators.max(this.validateTyres.frontToeMax),
        ]
      ],
      rearLeftToe: [
        this.tyresValues.rearLeftToe,
        [
          Validators.required,
          Validators.min(this.validateTyres.rearToeMin),
          Validators.max(this.validateTyres.rearToeMax),
        ]
      ],
      rearRightToe: [
        this.tyresValues.rearRightToe,
        [
          Validators.required,
          Validators.min(this.validateTyres.rearToeMin),
          Validators.max(this.validateTyres.rearToeMax),
        ]
      ],

      casterLeft: [
        this.tyresValues.casterLeft,
        [
          Validators.required,
          Validators.min(this.validateTyres.casterMin),
          Validators.max(this.validateTyres.casterMax),
        ]
      ],
      casterRight: [
        this.tyresValues.casterRight,
        [
          Validators.required,
          Validators.min(this.validateTyres.casterMin),
          Validators.max(this.validateTyres.casterMax),
        ]
      ],
    });
  }
}
