import {Component, Input} from '@angular/core';
import {Dampers} from "../../model/setup/dampers";
import {ValidateDampers} from "../../model/validateSetup/validate-dampers";

@Component({
  selector: 'app-dampers',
  templateUrl: './dampers.component.html',
  styleUrls: ['./dampers.component.css']
})
export class DampersComponent{

  @Input() dampersValues: Dampers;
  @Input() validateDampers: ValidateDampers;
}
