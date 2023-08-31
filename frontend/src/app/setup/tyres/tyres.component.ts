import {Component, Input} from '@angular/core';
import {Tyres} from "../../model/setup/tyres";

@Component({
  selector: 'app-tyres',
  templateUrl: './tyres.component.html',
  styleUrls: ['./tyres.component.css']
})
export class TyresComponent{
  @Input() tyresValues: Tyres;

}
