import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private http: HttpClient) {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });

    this.LoginUser = this.LoginUser.bind(this);
  }

  LoginUser() {
    this.http.get(`/api/v1/user/${this.Username.value}`, this.loginForm.value)
      .subscribe((res) => {
        console.log(res);
      });
  }

  get Username(): FormControl {
    return this.loginForm.get("username") as FormControl
  }
  get Password(): FormControl {
    return this.loginForm.get("password") as FormControl
  }

}
