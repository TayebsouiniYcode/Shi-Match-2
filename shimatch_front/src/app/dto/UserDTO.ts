import { AddressDTO } from "./AddressDTO";
import { RoleDTO } from "./RoleDTO";
import { TeamDTO } from "./TeamDTO";

export class UserDTO {
  firstname?: string;
  lastname?: string;
  dateOfBirth?: Date;
  email?: string;
  username?: string;
  password?: string;
  phone?: string;
  poste?: string;
  favoriteFoot?: string;
  weight?: number;
  height?: number;
  team?: TeamDTO;
  address?: AddressDTO;
  role?: RoleDTO;
}
