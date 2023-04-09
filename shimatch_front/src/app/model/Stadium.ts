import { Match } from "./Match";

export class Stadium {
  id?: number;
  name?: string;
  city?: string;
  country?: string;
  zipCode?: string;
  phone?: string;
  email?: string;
  matchs?: Match[];
}
