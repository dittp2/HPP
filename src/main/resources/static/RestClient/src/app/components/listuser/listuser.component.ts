import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { Right } from '../../right';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';



@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  private users: User[];
  private rights: Right[];
  private healthprofessional: HealthProfessional;
  private idSearch;
  private fnameSearch;
  private lnameSearch;
  private genderSearch;

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/components/listpatient/listpatient.component.ts
  constructor(private _patientService: PatientService, private _router: Router) { }
/*
* This function initalize the view. It get all patient from the logged healthprofessional.
*/
=======
  constructor(private _userService: UserService, private _router: Router) { }

>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/components/listuser/listuser.component.ts
  ngOnInit() {
    this.healthprofessional = this._userService.getterH();
    console.log(this.healthprofessional);
<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/components/listpatient/listpatient.component.ts
      this._patientService.getPatientsHealth(this.healthprofessional.id).subscribe((patients) => {
      console.log(patients);
      this.patients = patients;
=======
    // this._userService.getRights(this.healthprofessional.id).subscribe((rights) => {
    //   this.rights = rights;
    //   console.log(rights);
      
         


    // },(error) => {
    //     console.log(error);
    //   });

    this._userService.getUsersHealth(this.healthprofessional.id).subscribe((users) => {
      console.log(users);
      this.users = users;
      
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/components/listuser/listuser.component.ts
    }, (error) => {
      console.log(error);
    });
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/components/listpatient/listpatient.component.ts
/*
* This function delete the given patient
*/
  deletePatient(patient) {
    this._patientService.deletePatient(patient.id).subscribe((data) => {
=======
  deleteUser(user) {
    this._userService.deleteUser(user.id).subscribe((data) => {
    
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/components/listuser/listuser.component.ts
    }, (error) => {
      console.log(error);
    });
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/components/listpatient/listpatient.component.ts
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
=======
  updateUser(user) {
    this._userService.setter(user);
    this._router.navigate(['/dossier']);
  }


  searchUser() {
    
    console.log(this.fnameSearch);
    // Suche nach Name und Vorname und oder Geschlecht.
    this._userService.getSearchUsers(this.fnameSearch,this.lnameSearch).subscribe((users) => {
     
      console.log(users);
      this.users = users;

>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/components/listuser/listuser.component.ts
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

