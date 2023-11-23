import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MechanicalGrip} from "../../../model/setup/mechanical-grip";
import {ValidateMechanicalGrip} from "../../../model/validateSetup/validate-mechanical-grip";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-mechanical-grip',
  templateUrl: './mechanical-grip.component.html',
  styleUrls: ['./mechanical-grip.component.css']
})
export class MechanicalGripComponent implements OnInit{
  @Input() mechanicalGripValues: MechanicalGrip;
  @Input() validateMechanicalGrip: ValidateMechanicalGrip;
  @Output() dataUpdate = new EventEmitter<MechanicalGrip>();
  mechanicalGripForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.initializeForm();

    this.mechanicalGripForm.valueChanges.subscribe((formValue) => {
      this.mechanicalGripValues = formValue;
      this.dataUpdate.emit(this.mechanicalGripForm.value);
    });
  }

  initializeForm() {
    this.mechanicalGripForm = this.formBuilder.group({
      frontAntiRollBar: [
        this.mechanicalGripValues.frontAntiRollBar,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontAntiRollBarMin),
          Validators.max(this.validateMechanicalGrip.frontAntiRollBarMax),
        ]
      ],
      brakePower: [
        this.mechanicalGripValues.brakePower,
        [
          Validators.required
        ]
      ],
      brakeBias: [
        this.mechanicalGripValues.brakeBias,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.brakeBiasMin),
          Validators.max(this.validateMechanicalGrip.brakeBiasMax),
        ]
      ],
      steerRatio: [
        this.mechanicalGripValues.steerRatio,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.steerRatioMin),
          Validators.max(this.validateMechanicalGrip.steerRatioMax),
        ]
      ],

      frontLeftWheelRate: [
        this.mechanicalGripValues.frontLeftWheelRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontWheelRateMin),
          Validators.max(this.validateMechanicalGrip.frontWheelRateMax),
        ]
      ],
      frontRightWheelRate: [
        this.mechanicalGripValues.frontRightWheelRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontWheelRateMin),
          Validators.max(this.validateMechanicalGrip.frontWheelRateMax),
        ]
      ],
      rearLeftWheelRate: [
        this.mechanicalGripValues.rearLeftWheelRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearWheelRateMin),
          Validators.max(this.validateMechanicalGrip.rearWheelRateMax),
        ]
      ],
      rearRightWheelRate: [
        this.mechanicalGripValues.rearRightWheelRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearWheelRateMin),
          Validators.max(this.validateMechanicalGrip.rearWheelRateMax),
        ]
      ],

      frontLeftBumpstopRate: [
        this.mechanicalGripValues.frontLeftBumpstopRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontBumpStopRateMin),
          Validators.max(this.validateMechanicalGrip.frontBumpStopRateMax),
        ]
      ],
      frontRightBumpstopRate: [
        this.mechanicalGripValues.frontRightBumpstopRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontBumpStopRateMin),
          Validators.max(this.validateMechanicalGrip.frontBumpStopRateMax),
        ]
      ],
      rearLeftBumpstopRate: [
        this.mechanicalGripValues.rearLeftBumpstopRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearBumpStopRateMin),
          Validators.max(this.validateMechanicalGrip.rearBumpStopRateMax),
        ]
      ],
      rearRightBumpstopRate: [
        this.mechanicalGripValues.rearRightBumpstopRate,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearBumpStopRateMin),
          Validators.max(this.validateMechanicalGrip.rearBumpStopRateMax),
        ]
      ],

      frontLeftBumpstopRange: [
        this.mechanicalGripValues.frontLeftBumpstopRange,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontBumpStopRangeMin),
          Validators.max(this.validateMechanicalGrip.frontBumpStopRangeMax),
        ]
      ],
      frontRightBumpstopRange: [
        this.mechanicalGripValues.frontRightBumpstopRange,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.frontBumpStopRangeMin),
          Validators.max(this.validateMechanicalGrip.frontBumpStopRangeMax),
        ]
      ],
      rearLeftBumpstopRange: [
        this.mechanicalGripValues.rearLeftBumpstopRange,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearBumpStopRangeMin),
          Validators.max(this.validateMechanicalGrip.rearBumpStopRangeMax),
        ]
      ],
      rearRightBumpstopRange: [
        this.mechanicalGripValues.rearRightBumpstopRange,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearBumpStopRangeMin),
          Validators.max(this.validateMechanicalGrip.rearBumpStopRangeMax),
        ]
      ],

      rearAntiRollBar: [
        this.mechanicalGripValues.rearAntiRollBar,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.rearAntiRollBarMin),
          Validators.max(this.validateMechanicalGrip.rearAntiRollBarMax),
        ]
      ],
      preloadDifferential: [
        this.mechanicalGripValues.preloadDifferential,
        [
          Validators.required,
          Validators.min(this.validateMechanicalGrip.preloadDifferentialMin),
          Validators.max(this.validateMechanicalGrip.preloadDifferentialMax),
        ]
      ],
    });
  }
}
