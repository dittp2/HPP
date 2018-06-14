import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { User } from '../user';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { HealthProfessional } from '../healthProfessional';


@Injectable()
export class UserService {
  private baseUrl: String = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
  private user = new User();
  private notfall: boolean;
  private healthprofessional = new HealthProfessional();
  constructor(private _http: Http) { }

  /*
* This function get the Healthprofessional, whose has the right Login and Password
*/
  getHealthProfessionalsLogin(login : String, pass: String) {
    return this._http.get(this.baseUrl + '/healthProfessionals/'+login+'&'+pass, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function get all Patient
*/
  getPatients() {
    return this._http.get(this.baseUrl + '/patients', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function get all Patient of given Healthprofessional
*/
  getPatientsHealth(healthp : Number) {
    return this._http.get(this.baseUrl + '/patients/'+healthp, this.options).map((response: Response) => response.json())
=======
  getUsers() {
    return this._http.get(this.baseUrl + '/users', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }


  getUsersHealth(healthp : Number) {
    return this._http.get(this.baseUrl + '/users/'+healthp, this.options).map((response: Response) => response.json())
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts
      .catch(this.errorHandler);
  }

/*
* This function get all rights
*/
  getRights(healthp : Number) {
    return this._http.get(this.baseUrl + '/rights/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  
<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function get all Patient, which is matched with firstname or/and lastname
*/
  getSearchPatients(fname:String, lname:String) {
    return this._http.get(this.baseUrl + '/patients/'+fname+'&'+lname, this.options).map((response: Response) => response.json())
       .catch(this.errorHandler);
   }

/*
* This function get on patient
*/
  getPatient(id: Number) {
=======
  getSearchUsers(fname:String, lname:String) {

    return this._http.get(this.baseUrl + '/users/'+fname+'&'+lname, this.options).map((response: Response) => response.json())
       .catch(this.errorHandler);
   }

  getUser(id: Number) {
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts

    return this._http.get(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function delete the patient with the given id
*/
  deletePatient(id: Number) {
=======
  deleteUser(id: Number) {
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts

    return this._http.delete(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function create the patient
*/
  createUser(patient: Patient) {
=======

  createUser(user: User) {
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts

    return this._http.post(this.baseUrl + '/user', JSON.stringify(user),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function update the patient
*/
   updateUser(patient: Patient) {
=======
   updateUser(user: User) {
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts

    return this._http.put(this.baseUrl + '/user', JSON.stringify(user),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function handle the errer
*/
  errorHandler(error: Response) {

     return Observable.throw(error || 'SERVER ERROR');
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
/*
* This function set the patient in initialvariable
*/
   setter(patient: Patient) {
     this.patient = patient;
=======
   setter(user: User) {
     this.user = user;
>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts
   }

/*
* This function set the Healthprofessional in initialvariable
*/
   setterH(healthProfessional: HealthProfessional) {
    this.healthprofessional = healthProfessional;
  }

/*
* This function get the Healthprofessional of initialvariable
*/
  getterH() {
    return this.healthprofessional;
  }

/*
* This function get the patient of initialvariable
*/
  getter() {
    return this.user;
  }

/*
* This function set the boolean of emergency in initialvariable notfall
*/
  setNotfall(notfall:boolean){
    this.notfall = notfall;
  }

/*
* This function get the boolean of emergency of initialvariable notfall
*/
  getNotfall(){
    return this.notfall
  }

<<<<<<< HEAD:src/main/resources/static/RestClient/src/app/shared-service/patient.service.ts
=======
  // setRight(

  // )
  /*
  searchUser(id: Number) {
    angular.isArray(users);
    return this._http.get(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  */

>>>>>>> parent of 2042fdf... umbrenennt:src/main/resources/static/RestClient/src/app/shared-service/user.service.ts
}
