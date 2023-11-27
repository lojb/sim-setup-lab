import {Component} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../service/auth.service";
import {environment} from "../../../environments/environment.development";
import {RequestService} from "../../service/request.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private auth: AuthService,
              private requestService: RequestService
  ) {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', [Validators.required, this.PasswordMatchValidator]]
    });

    this.RegisterUser = this.RegisterUser.bind(this);
  }

  RegisterUser() {
    this.requestService.registerUser(this.registerForm.value)
      .subscribe((user: any) => {
          this.auth.login(user);
        }
      );

  }


  PasswordMatchValidator(control: AbstractControl) {
    const password = control.get('password');
    const confirmPassword = control.get('confirmPassword');

    return confirmPassword && password && password.value !== confirmPassword.value;
  }


  get Username(): FormControl {
    return this.registerForm.get("username") as FormControl
  }

  get Email(): FormControl {
    return this.registerForm.get("email") as FormControl
  }

  get Password(): FormControl {
    return this.registerForm.get("password") as FormControl
  }

  get ConfirmPassword(): FormControl {
    return this.registerForm.get("confirmPassword") as FormControl
  }
}
