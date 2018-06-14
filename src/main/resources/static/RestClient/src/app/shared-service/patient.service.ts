import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Patient } from '../patient';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { HealthProfessional } from '../healthProfessional';


@Injectable()
export class PatientService {
  private baseUrl: String = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
  private patient = new Patient();
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
      .catch(this.errorHandler);
  }

/*
* This function get all rights
*/
  getRights(healthp : Number) {
    return this._http.get(this.baseUrl + '/rights/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  
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

    return this._http.get(this.baseUrl + '/patient/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function delete the patient with the given id
*/
  deletePatient(id: Number) {

    return this._http.delete(this.baseUrl + '/patient/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function create the patient
*/
  createUser(patient: Patient) {

    return this._http.post(this.baseUrl + '/patient', JSON.stringify(patient),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function update the patient
*/
   updateUser(patient: Patient) {

    return this._http.put(this.baseUrl + '/patient', JSON.stringify(patient),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function handle the errer
*/
  errorHandler(error: Response) {

     return Observable.throw(error || 'SERVER ERROR');
  }

/*
* This function set the patient in initialvariable
*/
   setter(patient: Patient) {
     this.patient = patient;
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
    return this.patient;
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

}
