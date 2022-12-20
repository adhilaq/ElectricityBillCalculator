import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { GetAllBillComponent } from './get-all-bill/get-all-bill.component';
import { GetBillbyCityComponent } from './get-billby-city/get-billby-city.component';
import { GetBillbyAreaComponent } from './get-billby-area/get-billby-area.component';
import { GetBillbyYearComponent } from './get-billby-year/get-billby-year.component';
import { InsertBillComponent } from './insert-bill/insert-bill.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    WelcomePageComponent,
    UserloginComponent,
    AdmindashboardComponent,
    GetAllBillComponent,
    GetBillbyCityComponent,
    GetBillbyAreaComponent,
    GetBillbyYearComponent,
    InsertBillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
