import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HealthProfessional } from '../healthProfessional';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class HealthProfessionalService {
  private baseUrl: String = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
  private healthProfessional = new HealthProfessional();
  constructor(private _http: Http) { }

/*
* This function get all Healthprofessional from DB
*/
  getHealthProfesssionals() {
    return this._http.get(this.baseUrl + '/healthProfessionals', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
/*
* This function handle the error
*/
  errorHandler(error: Response) {
    return Observable.throw(error || 'SERVER ERROR');
  }

/*
* This function set the Healthprofessional in initialvariable
*/
  setter(healthProfessional: HealthProfessional) {
    this.healthProfessional = healthProfessional;
  }

/*
* This function get the Healthprofessional of initialvariable
*/
  getter() {
   return this.healthProfessional;
  }
}
