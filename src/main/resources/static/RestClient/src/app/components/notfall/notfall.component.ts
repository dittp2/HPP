import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';



@Component({
  selector: 'app-notfall',
  templateUrl: './notfall.component.html',
  styleUrls: ['./notfall.component.css']
})
export class NotfallComponent implements OnInit {
  private users: User[];
  private healthprofessional: HealthProfessional;
  private idSearch;
  private fnameSearch;
  private lnameSearch;
  private genderSearch;

  constructor(private _userService: UserService, private _router: Router) { }

/*
* This function initalize the view. It get all patient.
*/
  ngOnInit() {
    this.healthprofessional = this._userService.getterH();
    console.log(this.healthprofessional);
    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users = users;
      
    }, (error) => {
      console.log(error);
    });
<<<<<<< HEAD
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
=======

  
   
  }

  deleteUser(user) {
    this._userService.deleteUser(user.id).subscribe((data) => {
    
    }, (error) => {
      console.log(error);
    });
  }

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

>>>>>>> parent of 2042fdf... umbrenennt
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
