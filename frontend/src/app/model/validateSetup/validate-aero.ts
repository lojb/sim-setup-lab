export class ValidateAero {
  frontRideHeightMin: number;
  frontRideHeightMax: number;
  rearRideHeightMin: number;
  rearRideHeightMax: number;
  splitterMin: number;
  splitterMax: number;
  rearWingMin: number;
  rearWingMax: number;
  frontBrakeDuctsMin: number;
  frontBrakeDuctsMax: number;
  rearBrakeDuctsMin: number;
  rearBrakeDuctsMax: number;

  ValidateFrontRideHeight(frontRideHeight: number): boolean {
    return frontRideHeight >= this.frontRideHeightMin && frontRideHeight <= this.frontRideHeightMax
  }

  ValidateRearRideHeight(rearRideHeight: number) {
    return rearRideHeight >= this.rearRideHeightMin && rearRideHeight <= this.rearRideHeightMax
  }

  ValidateSplitter(splitter: number) {
    return splitter >= this.splitterMin && splitter <= this.splitterMax
  }

  ValidateRearWing(rearWing: number) {
    return rearWing >= this.rearWingMin && rearWing <= this.rearWingMax
  }

  ValidateFrontBrakeDucts(frontBrakeDucts: number) {
    return frontBrakeDucts >= this.frontBrakeDuctsMin && frontBrakeDucts <= this.frontBrakeDuctsMax
  }

  ValidateRearBrakeDucts(rearBrakeDucts: number) {
    return rearBrakeDucts >= this.rearBrakeDuctsMin && rearBrakeDucts <= this.rearBrakeDuctsMax
  }
}
