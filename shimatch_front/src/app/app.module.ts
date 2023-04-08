import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HeaderComponent } from './layouts/header/header.component';
import { RegisterComponent } from './pages/register/register.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { ManageUsersComponent } from './pages/admin/manage-users/manage-users.component';
import { ManageStadiumComponent } from './pages/admin/manage-stadium/manage-stadium.component';
import { ManageMatchComponent } from './pages/admin/manage-match/manage-match.component';
import { ManageTeamsComponent } from './pages/admin/manage-teams/manage-teams.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    RegisterComponent,
    LoginComponent,
    DashboardComponent,
    SidebarComponent,
    HomeComponent,
    ManageUsersComponent,
    ManageStadiumComponent,
    ManageMatchComponent,
    ManageTeamsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
