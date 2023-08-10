import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder) {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });

    this.LoginUser = this.LoginUser.bind(this);
  }

  LoginUser() {
    console.log(this.loginForm.value)
  }

  get Username(): FormControl {
    return this.loginForm.get("username") as FormControl
  }
  get Password(): FormControl {
    return this.loginForm.get("password") as FormControl
  }

}
