import {ValidateAero} from "./validate-aero";
import {ValidateDampers} from "./validate-dampers";
import {ValidateElectronics} from "./validate-electronics";
import {ValidateFuelStrategy} from "./validate-fuel-strategy";
import {ValidateMechanicalGrip} from "./validate-mechanical-grip";
import {ValidateTyres} from "./validate-tyres";

export class ValidateSetup {
  carType: string;
  id: number;
  validateAero: ValidateAero;
  validateDampers: ValidateDampers;
  validateElectronics: ValidateElectronics;
  validateFuelStrategy: ValidateFuelStrategy;
  validateMechanicalGrip: ValidateMechanicalGrip;
  validateTyres: ValidateTyres;
}
