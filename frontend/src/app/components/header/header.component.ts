import { Component } from '@angular/core';
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private auth: AuthService) {

  }

  LogoutUser() {
    this.auth.logout();
  }

  protected readonly localStorage = localStorage;
}
