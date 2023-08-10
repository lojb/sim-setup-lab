import {Component} from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  registerUserData = {
    username: "",
    email: "",
    password: "",
    confirmPassword: ""
  };
  registerUser() {
    console.log(this.registerUserData)
  };
}
