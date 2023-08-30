import {Component, Input} from '@angular/core';
import {Aero} from "../../model/aero";

@Component({
  selector: 'app-aero',
  templateUrl: './aero.component.html',
  styleUrls: ['./aero.component.css']
})
export class AeroComponent {

  @Input() aeroValues: Aero;
}
