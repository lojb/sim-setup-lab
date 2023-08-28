import { Component } from '@angular/core';
import {TyresComponent} from "./tyres/tyres.component";
import {ElectronicsComponent} from "./electronics/electronics.component";
import {FuelStrategyComponent} from "./fuel-strategy/fuel-strategy.component";
import {MechanicalGripComponent} from "./mechanical-grip/mechanical-grip.component";
import {DampersComponent} from "./dampers/dampers.component";
import {AeroComponent} from "./aero/aero.component";
import {SetupPart} from "./setup-part";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: SetupPart | undefined;

  toggle(setupPart: SetupPart) {
    this.selectedSetupPart = setupPart;
  }

  protected readonly TyresComponent = TyresComponent;
  protected readonly ElectronicsComponent = ElectronicsComponent;
  protected readonly FuelStrategyComponent = FuelStrategyComponent;
  protected readonly MechanicalGripComponent = MechanicalGripComponent;
  protected readonly DampersComponent = DampersComponent;
  protected readonly AeroComponent = AeroComponent;
}
