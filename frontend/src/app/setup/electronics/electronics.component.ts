import {Component, Input} from '@angular/core';
import {Electronics} from "../../model/electronics";

@Component({
  selector: 'app-electronics',
  templateUrl: './electronics.component.html',
  styleUrls: ['./electronics.component.css']
})
export class ElectronicsComponent{
  @Input() electronicsValues: Electronics;
}
