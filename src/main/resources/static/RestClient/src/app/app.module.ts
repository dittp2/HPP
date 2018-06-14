import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';

import { PatientService } from './shared-service/patient.service';
import { HealthProfessionalService } from './shared-service/healthprofessional.service';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { MatButtonModule, MatCardModule, MatToolbarModule, MatMenuModule, MatInputModule, MatIconModule } from '@angular/material';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ListpatientComponent } from './components/listpatient/listpatient.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { LoginComponent } from './components/login/login.component';
import { NotfallComponent } from './components/notfall/notfall.component';
import { Patient } from './patient';
import { HealthProfessional } from './healthProfessional';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MaterialModule } from './material.module';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCheckboxModule } from '@angular/material/checkbox';


const appRoutes: Routes = [
  {path: 'dashboard', component: ListpatientComponent},
  {path: 'dossier', component: UserFormComponent},
  {path: '', component: LoginComponent},
  {path: 'notfall', component: NotfallComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListpatientComponent,
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
  providers: [PatientService, HealthProfessionalService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
