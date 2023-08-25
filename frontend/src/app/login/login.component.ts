import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private http: HttpClient,
              private auth: AuthService
  ) {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });

    this.LoginUser = this.LoginUser.bind(this);
  }

  LoginUser() {
    this.http.post(`http://localhost:8080/api/v1/auth/authenticate`, this.loginForm.value)
      .subscribe((user: any) => {
        console.log(user)
        this.auth.login(user);
      });
  }

  get Username(): FormControl {
    return this.loginForm.get("username") as FormControl
  }
  get Password(): FormControl {
    return this.loginForm.get("password") as FormControl
  }

}
