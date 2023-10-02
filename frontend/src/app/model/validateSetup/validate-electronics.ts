export class ValidateElectronics {
  tractionControlMin: number;
  tractionControlMax: number;
  absMin: number;
  absMax: number;
  ecuMapMin: number;
  ecuMapMax: number;
  telemetryLapsMin: number;
  telemetryLapsMax: number;


  ValidateTractionControl(tractionControl: number) {
    return tractionControl >= this.tractionControlMin && tractionControl <= this.tractionControlMax;
  }

  ValidateAbs(abs: number) {
    return abs >= this.absMin && abs <= this.absMax;
  }

  ValidateEcuMap(ecuMap: number) {
    return ecuMap >= this.ecuMapMin && ecuMap <= this.ecuMapMax;
  }

  ValidateTelemetryLaps(telemetryLaps: number) {
    return telemetryLaps >= this.telemetryLapsMin && telemetryLaps <= this.telemetryLapsMax;
  }
}
