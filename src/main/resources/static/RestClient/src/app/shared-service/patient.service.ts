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

  getHealthProfessionalsLogin(login : String, pass: String) {
    return this._http.get(this.baseUrl + '/healthProfessionals/'+login+'&'+pass, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  getPatients() {
    return this._http.get(this.baseUrl + '/patients', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }


  getPatientsHealth(healthp : Number) {
    return this._http.get(this.baseUrl + '/patients/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  getRights(healthp : Number) {
    return this._http.get(this.baseUrl + '/rights/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  
  getSearchPatients(fname:String, lname:String) {

    return this._http.get(this.baseUrl + '/patients/'+fname+'&'+lname, this.options).map((response: Response) => response.json())
       .catch(this.errorHandler);
   }

  getPatient(id: Number) {

    return this._http.get(this.baseUrl + '/patient/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  deletePatient(id: Number) {

    return this._http.delete(this.baseUrl + '/patient/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }


  createUser(patient: Patient) {

    return this._http.post(this.baseUrl + '/patient', JSON.stringify(patient),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

   updateUser(patient: Patient) {

    return this._http.put(this.baseUrl + '/patient', JSON.stringify(patient),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error: Response) {

     return Observable.throw(error || 'SERVER ERROR');
  }

   setter(patient: Patient) {
     this.patient = patient;
   }

   setterH(healthProfessional: HealthProfessional) {
    this.healthprofessional = healthProfessional;
  }

  getterH() {
    return this.healthprofessional;
  }

  getter() {
    return this.patient;
  }


  setNotfall(notfall:boolean){
    this.notfall = notfall;
  }

  getNotfall(){
    return this.notfall
  }

  // setRight(

  // )
  /*
  searchPatient(id: Number) {
    angular.isArray(patients);
    return this._http.get(this.baseUrl + '/patient/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  */

}
