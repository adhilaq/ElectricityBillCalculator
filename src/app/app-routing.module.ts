import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { GetAllBillComponent } from './get-all-bill/get-all-bill.component';
import { GetBillbyAreaComponent } from './get-billby-area/get-billby-area.component';
import { GetBillbyCityComponent } from './get-billby-city/get-billby-city.component';
import { GetBillbyYearComponent } from './get-billby-year/get-billby-year.component';
import { InsertBillComponent } from './insert-bill/insert-bill.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';

const routes: Routes = [
  {
    path:'',
    component:WelcomePageComponent,
    pathMatch:"full"
  },
  {
    path:'AdminLogin',
    component:AdminLoginComponent,
    pathMatch:'full',
  },
  {
    path:'UserLogin',
    component:UserloginComponent,
    pathMatch:'full'
  }, 

  {
    path:'AdminDashboard',
    component:AdmindashboardComponent,
    pathMatch:'full',
  },
  {
    path:'AllBills',
    component:GetAllBillComponent,
    pathMatch:'full'
  },
  {
    path:'BillByCity',
    component:GetBillbyCityComponent,
    pathMatch:'full'
  },
  {
    path:'BillByArea',
    component:GetBillbyAreaComponent,
    pathMatch:'full'
  },
  {
    path:"BillByYear",
    component:GetBillbyYearComponent,
    pathMatch:'full'
  },
  {
    path:"InsertBill",
    component:InsertBillComponent,
    pathMatch:'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
