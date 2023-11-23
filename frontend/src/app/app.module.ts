import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {NgOptimizedImage} from "@angular/common";
import {LoginComponent} from './components/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {RegisterComponent} from './components/register/register.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "./service/authentication/auth.service";
import {SetupComponent} from './components/setup/setup.component';
import {TyresComponent} from './components/setup/tyres/tyres.component';
import {ElectronicsComponent} from './components/setup/electronics/electronics.component';
import {FuelStrategyComponent} from './components/setup/fuel-strategy/fuel-strategy.component';
import {MechanicalGripComponent} from './components/setup/mechanical-grip/mechanical-grip.component';
import {DampersComponent} from './components/setup/dampers/dampers.component';
import {AeroComponent} from './components/setup/aero/aero.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from './components/admin/admin.component';
import { MySetupsComponent } from './components/mySetups/mySetups.component';
import { FooterComponent } from './components/footer/footer.component';


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
    AeroComponent,
    AdminComponent,
    MySetupsComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgOptimizedImage,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
