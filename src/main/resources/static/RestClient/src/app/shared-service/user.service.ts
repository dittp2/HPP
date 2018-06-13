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

  getHealthProfessionalsLogin(login : String, pass: String) {
    return this._http.get(this.baseUrl + '/healthProfessionals/'+login+'&'+pass, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  getUsers() {
    return this._http.get(this.baseUrl + '/users', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }


  getUsersHealth(healthp : Number) {
    return this._http.get(this.baseUrl + '/users/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  getRights(healthp : Number) {
    return this._http.get(this.baseUrl + '/rights/'+healthp, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  
  getSearchUsers(fname:String, lname:String) {

    return this._http.get(this.baseUrl + '/users/'+fname+'&'+lname, this.options).map((response: Response) => response.json())
       .catch(this.errorHandler);
   }

  getUser(id: Number) {

    return this._http.get(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  deleteUser(id: Number) {

    return this._http.delete(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }


  createUser(user: User) {

    return this._http.post(this.baseUrl + '/user', JSON.stringify(user),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

   updateUser(user: User) {

    return this._http.put(this.baseUrl + '/user', JSON.stringify(user),  this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error: Response) {

     return Observable.throw(error || 'SERVER ERROR');
  }

   setter(user: User) {
     this.user = user;
   }

   setterH(healthProfessional: HealthProfessional) {
    this.healthprofessional = healthProfessional;
  }

  getterH() {
    return this.healthprofessional;
  }

  getter() {
    return this.user;
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
  searchUser(id: Number) {
    angular.isArray(users);
    return this._http.get(this.baseUrl + '/user/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }
  */

}
