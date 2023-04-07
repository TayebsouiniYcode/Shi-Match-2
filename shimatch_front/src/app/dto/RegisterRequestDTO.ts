export class RegisterRequestDTO {
  firstname: string;
  lastname: string;
  //TODO Address
  //TODO dateOfBirth
  phone: string;
  email: string;
  username: string;
  password: string;

  constructor() {
    this.email = "";
    this.firstname = "";
    this.lastname = "";
    this.email= "";
    this.phone= "";
    this.username= "";
    this.password= "";
  }
}
