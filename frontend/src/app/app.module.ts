import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {NgOptimizedImage} from "@angular/common";
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {RegisterComponent} from './register/register.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {SetupComponent} from './setup/setup.component';
import {TyresComponent} from './setup/tyres/tyres.component';
import {ElectronicsComponent} from './setup/electronics/electronics.component';
import {FuelStrategyComponent} from './setup/fuel-strategy/fuel-strategy.component';
import {MechanicalGripComponent} from './setup/mechanical-grip/mechanical-grip.component';
import {DampersComponent} from './setup/dampers/dampers.component';
import {AeroComponent} from './setup/aero/aero.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    SetupComponent,
    TyresComponent,
    ElectronicsComponent,
    FuelStrategyComponent,
    MechanicalGripComponent,
    DampersComponent,
    AeroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgOptimizedImage,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
