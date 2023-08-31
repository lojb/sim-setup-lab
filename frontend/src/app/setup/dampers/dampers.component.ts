import {Component, Input} from '@angular/core';
import {Dampers} from "../../model/setup/dampers";

@Component({
  selector: 'app-dampers',
  templateUrl: './dampers.component.html',
  styleUrls: ['./dampers.component.css']
})
export class DampersComponent{

  @Input() dampersValues: Dampers;
}
