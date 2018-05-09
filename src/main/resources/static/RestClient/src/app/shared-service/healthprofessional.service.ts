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

  getHealthProfesssionals() {
    return this._http.get(this.baseUrl + '/healthprofessionals', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error: Response) {

    return Observable.throw(error || 'SERVER ERROR');
 }

 setter(healthProfessional: HealthProfessional) {
    this.healthProfessional = healthProfessional;
  }

 getter() {
   return this.healthProfessional;
 }
}
