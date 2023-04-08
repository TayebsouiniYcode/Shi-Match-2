import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AuthGuard } from './guard/auth-guard.guard';
import { ManageUsersComponent } from './pages/admin/manage-users/manage-users.component';
import { ManageStadiumComponent } from './pages/admin/manage-stadium/manage-stadium.component';
import { ManageMatchComponent } from './pages/admin/manage-match/manage-match.component';
import { ManageTeamsComponent } from './pages/admin/manage-teams/manage-teams.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: "dashboard" , component: DashboardComponent, canActivate: [AuthGuard]},
  { path: "admin/users", component: ManageUsersComponent, canActivate: [AuthGuard]},
  { path: "admin/stadium", component: ManageStadiumComponent, canActivate: [AuthGuard]},
  { path: "admin/match", component: ManageMatchComponent, canActivate: [AuthGuard]},
  { path: "admin/teams", component: ManageTeamsComponent, canActivate: [AuthGuard]},
];


@NgModule({
  declarations: [],
  // imports: [
  //   CommonModule
  // ]
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }