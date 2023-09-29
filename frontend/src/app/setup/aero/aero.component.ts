import {Component, Input} from '@angular/core';
import {Aero} from "../../model/setup/aero";
import {ValidateAero} from "../../model/validateSetup/validate-aero";

@Component({
  selector: 'app-aero',
  templateUrl: './aero.component.html',
  styleUrls: ['./aero.component.css']
})
export class AeroComponent {

  @Input() aeroValues: Aero;
  @Input() validateAero: ValidateAero;
}
