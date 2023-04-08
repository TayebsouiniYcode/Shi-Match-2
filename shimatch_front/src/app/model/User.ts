import { Address } from "./Address";
import { Role } from "./Role";
import { Team } from "./Team";

export class User{
  id!: number;
  firstname!: string;
  lastname!: string;
  email!: string;
  phone!: string;
  password!: string;
  username!: string;
  address!: Address;
  team!: Team;
  role!: Role;
  weight!: number;
  height!: number;
  photo!: string;
  favoriteFoot!: string;
}
