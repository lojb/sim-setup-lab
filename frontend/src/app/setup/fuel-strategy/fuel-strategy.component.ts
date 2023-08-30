import {Component, Input} from '@angular/core';
import {FuelStrategy} from "../../model/fuel-strategy";

@Component({
  selector: 'app-fuel-strategy',
  templateUrl: './fuel-strategy.component.html',
  styleUrls: ['./fuel-strategy.component.css']
})
export class FuelStrategyComponent{
  @Input() fuelStrategyValues: FuelStrategy;
}
