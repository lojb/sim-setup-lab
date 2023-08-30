import {Component, Input} from '@angular/core';
import {MechanicalGrip} from "../../model/mechanical-grip";

@Component({
  selector: 'app-mechanical-grip',
  templateUrl: './mechanical-grip.component.html',
  styleUrls: ['./mechanical-grip.component.css']
})
export class MechanicalGripComponent{
  @Input() mechanicalGripValues: MechanicalGrip;
}
