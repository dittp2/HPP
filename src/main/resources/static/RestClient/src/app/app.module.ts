import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';

import { UserService } from './shared-service/user.service';
import { HealthProfessionalService } from './shared-service/healthprofessional.service';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { DocumentService } from './document.service';

import { MatButtonModule, MatCardModule, MatToolbarModule, MatMenuModule, MatInputModule, MatIconModule } from '@angular/material';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { LoginComponent } from './components/login/login.component';
import { NotfallComponent } from './components/notfall/notfall.component';
import { User } from './user';
import { HealthProfessional } from './healthProfessional';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MaterialModule } from './material.module';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCheckboxModule } from '@angular/material/checkbox';
//import {MatInputModule} from '@angular/material/input';

const appRoutes: Routes = [
  {path: 'dashboard', component: ListuserComponent},
  {path: 'dossier', component: UserFormComponent},
  {path: '', component: LoginComponent},
  {path: 'notfall', component: NotfallComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    LoginComponent,
    NotfallComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatMenuModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatDividerModule,
    MatGridListModule,
    MatSelectModule,
    MatCheckboxModule
  ],
  providers: [UserService, HealthProfessionalService, DocumentService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
