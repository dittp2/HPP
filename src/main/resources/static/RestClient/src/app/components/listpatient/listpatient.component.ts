import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../shared-service/patient.service';
import { Patient } from '../../patient';
import { Right } from '../../right';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';



@Component({
  selector: 'app-listpatient',
  templateUrl: './listpatient.component.html',
  styleUrls: ['./listpatient.component.css']
})
export class ListpatientComponent implements OnInit {
  private patients: Patient[];
  private rights: Right[];
  private healthprofessional: HealthProfessional;
  private idSearch;
  private fnameSearch;
  private lnameSearch;
  private genderSearch;

  constructor(private _patientService: PatientService, private _router: Router) { }
/*
* This function initalize the view. It get all patient from the logged healthprofessional.
*/
  ngOnInit() {
    this.healthprofessional = this._patientService.getterH();
    console.log(this.healthprofessional);
      this._patientService.getPatientsHealth(this.healthprofessional.id).subscribe((patients) => {
      console.log(patients);
      this.patients = patients;
    }, (error) => {
      console.log(error);
    });
  }

/*
* This function delete the given patient
*/
  deletePatient(patient) {
    this._patientService.deletePatient(patient.id).subscribe((data) => {
    }, (error) => {
      console.log(error);
    });
  }

/*
* This function set the given patient to the Service and navigated to the page user-form.component.
*/
  updatePatient(patient) {
    this._patientService.setter(patient);
    this._router.navigate(['/dossier']);
  }

/*
* This function looking for the patient. The input for searching is Fristname OR/AND Lastname
*/
searchPatient() {
    this._patientService.getSearchPatients(this.fnameSearch,this.lnameSearch).subscribe((patients) => {
      console.log(patients);
      this.patients = patients;
    }, (error) => {
      console.log(error);
    });

/*
* This function navigate to the mainpage (Login)
*/
  }
  Logout(){
    this._router.navigate(['/']);
      
  }
  
}
