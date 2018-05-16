import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { HealthProfessionalService } from '../../shared-service/healthprofessional.service';
import { User } from '../../user';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDividerModule} from '@angular/material/divider';
import { FormsModule } from '@angular/forms';
import { DocumentService } from './../../document.service';
import { Http, Response } from '@angular/http';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private user: User;
  private document;
  private healthProfessionals: HealthProfessional[];
  private _url = 'data.xml';


  constructor(private _userService: UserService, private _router: Router,
    private _healthProfessionalService: HealthProfessionalService, private _documentService: DocumentService, private _http: Http) { }

  navigateToHome() {
    this._router.navigate(['/']);
  }

  ngOnInit() {
    this.user = this._userService.getter();
    this._healthProfessionalService.getHealthProfesssionals().subscribe((healthProfessionals) => {
      console.log(healthProfessionals);
      this.healthProfessionals = healthProfessionals;
    }, (error) => {
    console.log(error);
  });
}


  processForm() {
    if (this.user.id === undefined) {
      this._userService.createUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/']);
      }, (error) => {
        console.log(error);
      });
    } else {
      this._userService.updateUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/']);
      }, (error) => {
        console.log(error);
      });

    }
  }

  getDocument() {
    console.log(this._http.get(this._url)
    .map((response: Response) => response.toString()));
    return this._http.get(this._url)
    .map((response: Response) => response.toString());

  }


// /Users/pascal/Documents/workspace-sts-3.9.3.RELEASE/HPP/src/main/resources/static/RestClient/src/app/components/user-form/
  readXML() {
    const xml = new XMLHttpRequest();
    // tslint:disable-next-line:max-line-length
    xml.open('GET', 'data.xml', false);
    xml.send();
    const xmlData = xml.responseText;
    document.write(xmlData);
  }


}



// getDocument() {
//   this.document = this._documentService.getDocument();
//   console.log(this.document);
//   return this.document;
//  }