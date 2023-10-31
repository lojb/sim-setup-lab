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
  track: string;
  setupType: string;
  aero : Aero = new Aero();
  dampers: Dampers = new Dampers();
  electronics: Electronics = new Electronics();
  fuelStrategy : FuelStrategy = new FuelStrategy() ;
  mechanicalGrip: MechanicalGrip = new MechanicalGrip();
  tyres: Tyres = new Tyres();
}
