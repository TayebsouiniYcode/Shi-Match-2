import { User } from "./User";

export class Team {
  id?: number;
  name?: string;
  image?: string;
  city?: string;
  country?: string;
  zipCode?: string;
  win?: number;
  draw?: number;
  lose?: number;
  users?: User[];
  capitaine?: User;
}
