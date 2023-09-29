export class ValidateDampers {
  frontBumpMin: number;
  frontBumpMax: number;
  frontFastBumpMin: number;
  frontFastBumpMax: number;
  frontReboundMin: number;
  frontReboundMax: number;
  frontFastReboundMin: number;
  frontFastReboundMax: number;
  rearBumpMin: number;
  rearBumpMax: number;
  rearFastBumpMin: number;
  rearFastBumpMax: number;
  rearReboundMin: number;
  rearReboundMax: number;
  rearFastReboundMin: number;
  rearFastReboundMax: number;

 ValidateFrontBump(frontLeftBump: number, frontRightBump: number) {
   return frontLeftBump >= this.frontBumpMin && frontLeftBump <= this.frontBumpMax
   && frontRightBump >= this.frontBumpMin && frontRightBump <= this.frontBumpMax;
}

ValidateFrontFastBump(frontLeftFastBump: number, frontRightFastBump: number) {
  return frontLeftFastBump >= this.frontFastBumpMin && frontLeftFastBump <= this.frontFastBumpMax
    && frontRightFastBump >= this.frontFastBumpMin && frontRightFastBump <= this.frontFastBumpMax;
}

ValidateFrontRebound(frontLeftRebound: number, frontRightRebound: number) {
  return frontLeftRebound >= this.frontReboundMin && frontLeftRebound <= this.frontReboundMax
  && frontRightRebound >= this.frontReboundMin && frontRightRebound <= this.frontReboundMax;
}

ValidateFrontFastRebound(frontLeftFastRebound: number, frontRightFastRebound: number) {
  return frontLeftFastRebound >= this.frontFastReboundMin && frontLeftFastRebound <= this.frontFastReboundMax
    && frontRightFastRebound >= this.frontFastReboundMin && frontRightFastRebound <= this.frontFastReboundMax;
}

ValidateRearBump(rearLeftBump: number, rearRightBump: number) {
  return rearLeftBump >= this.rearBumpMin && rearLeftBump <= this.rearBumpMax
  && rearRightBump >= this.rearBumpMin && rearRightBump <= this.rearBumpMax;
}

ValidateRearFastBump(rearLeftFastBump: number, rearRightFastBump: number) {
  return rearLeftFastBump >= this.rearFastBumpMin && rearLeftFastBump <= this.rearFastBumpMax
    && rearRightFastBump >= this.rearFastBumpMin && rearRightFastBump <= this.rearFastBumpMax;
}

ValidateRearRebound(rearLeftRebound: number, rearRightRebound: number) {
  return rearLeftRebound >= this.rearReboundMin && rearLeftRebound <= this.rearReboundMax
    && rearRightRebound >= this.rearReboundMin && rearRightRebound <= this.rearReboundMax;
}

ValidateRearFastRebound(rearLeftFastRebound: number, rearRightFastRebound: number) {
  return rearLeftFastRebound >= this.rearFastReboundMin && rearLeftFastRebound <= this.rearFastReboundMax
    && rearRightFastRebound >= this.rearFastReboundMin && rearRightFastRebound <= this.rearFastReboundMax;
}
}
