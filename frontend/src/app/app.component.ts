import {Component} from '@angular/core';
import {SocialAuthService} from "@abacritt/angularx-social-login";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular app';

  user: any;
  loggedIn: any;

  constructor(private authService: SocialAuthService, private http: HttpClient) {
  }

  ngOnInit() {
    localStorage.setItem('serverUrl', 'http://localhost:8080')
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
      localStorage.setItem('idToken', JSON.stringify(user.idToken));
      localStorage.setItem('email', JSON.stringify(user.email));
      localStorage.setItem('name', JSON.stringify(user.name));
      localStorage.setItem('provider', JSON.stringify(user.provider));
      localStorage.setItem('photoUrl', JSON.stringify(user.photoUrl));

      /*const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      const body = localStorage.getItem('idToken');
      const url = localStorage.getItem('serverUrl') + '/login';

      this.http.post('http://localhost:8080/api/auth/authenticate', body, { headers })
        .subscribe(
          (res: any) => {
            console.log(res);
          }
        );*/
    });
  }
}
