import {Component} from '@angular/core';
import {SetupValues} from "../model/setup-values";

@Component({
  selector: 'app-setup',
  templateUrl: './setup.component.html',
  styleUrls: ['./setup.component.css']
})
export class SetupComponent {

  selectedSetupPart: string | undefined;
  setupValues = new SetupValues();



  ToggleSelectedPart(setupPart: string) {
    this.selectedSetupPart = setupPart;
  }

  SubmitSetup() {
    console.log(this.setupValues)
  }
}
