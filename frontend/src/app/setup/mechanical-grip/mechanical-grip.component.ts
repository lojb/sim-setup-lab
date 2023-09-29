import {Component, Input} from '@angular/core';
import {MechanicalGrip} from "../../model/setup/mechanical-grip";
import {ValidateMechanicalGrip} from "../../model/validateSetup/validate-mechanical-grip";

@Component({
  selector: 'app-mechanical-grip',
  templateUrl: './mechanical-grip.component.html',
  styleUrls: ['./mechanical-grip.component.css']
})
export class MechanicalGripComponent{
  @Input() mechanicalGripValues: MechanicalGrip;
  @Input() validateMechanicalGrip: ValidateMechanicalGrip;
}
