import {Aero} from "./aero";
import {Dampers} from "./dampers";
import {Electronics} from "./electronics";
import {FuelStrategy} from "./fuel-strategy";
import {MechanicalGrip} from "./mechanical-grip";
import {Tyres} from "./tyres";

export class SetupValues {
  name: string;
  userId: number | null;
  carType: string;
  aero = new Aero();
  dampers = new Dampers();
  electronics = new Electronics();
  fuelStrategy = new FuelStrategy();
  mechanicalGrip = new MechanicalGrip();
  tyres = new Tyres();
}
