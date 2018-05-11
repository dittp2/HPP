import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DocumentService {
private _url = 'Kurzbericht_Spitalentlassung_Muster_Max_Kantonales_Spital.xml';


  constructor(private _http: Http) { }

  getDocument() {
    return this._http.get(this._url)
      .map((response: Response) => response.json());
  }


}
