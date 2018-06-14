import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Document } from './document';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()export class DocumentService {
  private baseUrl: String = 'http://localhost:8080/api';
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
  // private user = new User();
  private document = new Document();

  constructor(private _http: Http) { }

/*
* This function get all documents
*/
   getDocuments() {
    return this._http.get(this.baseUrl + '/documents', this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
   }

/*
* This function get one document
*/
  getDocument(id: Number) {

    return this._http.get(this.baseUrl + '/document/' + id, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

/*
* This function handle the error
*/
  errorHandler(error: Response) {

    return Observable.throw(error || 'SERVER ERROR');
 }

/*
* This function set the document in initialvariable
*/
  setter(document: Document) {
    this.document = document;
  }

/*
* This function get the patient of initialvariable
*/
 getter() {
   return this.document;
 }


}
