import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-aero',
  templateUrl: './aero.component.html',
  styleUrls: ['./aero.component.css']
})
export class AeroComponent{
  @Output() dataEmitter = new EventEmitter<any>();

  frontRideHeight: any;
  rearRideHeight: any;
  splitter: any;
  rearWing: any;
  frontBrakeDucts: any;
  rearBrakeDucts: any;

  sendData() {
    const aeroValues = {
      frontRideHeight: this.frontRideHeight,
      rearRideHeight: this.rearRideHeight,
      splitter: this.splitter,
      rearWing: this.rearWing,
      frontBrakeDucts: this.frontBrakeDucts,
      rearBrakeDucts: this.rearBrakeDucts
    };
    this.dataEmitter.emit(aeroValues);
  }
}
