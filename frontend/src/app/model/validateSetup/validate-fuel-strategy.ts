export class ValidateFuelStrategy {
  fuelMin: number;
  fuelMax: number;
  tyreType: string;
  brakesMin: number;
  brakesMax: number;
  fuelPerLap: number;

  ValidateFuel(fuel: number) {
    return fuel >= this.fuelMin && fuel <= this.fuelMax;
  }

  ValidateBrakes(brakes: number) {
    return brakes >= this.brakesMin && brakes <= this.brakesMax;
  }
}
