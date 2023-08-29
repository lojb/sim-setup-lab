import {Component} from '@angular/core';

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: string | undefined;

  toggle(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  receiveData(data: any) {

  }





  /*@ViewChild('TyresComponent', { static: false }) TyresComponent!: TyresComponent;
  @ViewChild('ElectronicComponent', { static: false }) ElectronicsComponent!: ElectronicsComponent;
  @ViewChild('FuelStrategyComponent', { static: false }) FuelStrategyComponent!: FuelStrategyComponent;
  @ViewChild('MechanicalGripComponent', { static: false }) MechanicalGripComponent!: MechanicalGripComponent;
  @ViewChild('DampersComponent', { static: false }) DampersComponent!: DampersComponent;
  @ViewChild('AeroComponent', { static: false }) AeroComponent!: AeroComponent;*/
}
