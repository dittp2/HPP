import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DocumentService {
private _url = 'data.xml';


  constructor(private _http: Http) { }

  getDocument() {
    return this._http.get(this._url)
    .map((response: Response) => response.toString());
  }


}
