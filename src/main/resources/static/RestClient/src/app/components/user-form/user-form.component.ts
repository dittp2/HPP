import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { HealthProfessionalService } from '../../shared-service/healthprofessional.service';
import { User } from '../../user';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatDividerModule } from '@angular/material/divider';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FormsModule } from '@angular/forms';
import { DocumentService } from './../../document.service';
import { Http, Response } from '@angular/http';
import { Document } from '../../document';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private user: User;
  private documents : Document;
  private healthProfessionals: HealthProfessional[];
  private _url = 'data.xml';

<<<<<<< HEAD
  constructor(private _patientService: PatientService, private _router: Router,
=======
  private iddoc;
  items = [];

  constructor(private _userService: UserService, private _router: Router,
>>>>>>> parent of 2042fdf... umbrenennt
    private _healthProfessionalService: HealthProfessionalService, private _documentService: DocumentService, private _http: Http) { }

/*
* This function navigated to the Dashboard.
*/   
  navigateToHome() {
    this._router.navigate(['/dashboard']);
  }

/*
* This function initalize the view. It get all healthprofessional and call the function getDocument of this class.
*/
  ngOnInit() {
    this.user = this._userService.getter();
    this._healthProfessionalService.getHealthProfesssionals().subscribe((healthProfessionals) => {
      console.log(healthProfessionals);
      this.healthProfessionals = healthProfessionals;
      this.healthProfessionals.splice(0,1);
    }, (error) => {
    console.log(error);
  });
  this.getDocument();
  }

/*
* This function show the information of patient, whose record is opened
*/ 
  processForm() {
    if (this.user.id === undefined) {
      this._userService.createUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/dashboard']);
      }, (error) => {
        console.log(error);
      });
    } else {
      this._userService.updateUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/dashboard']);
      }, (error) => {
        console.log(error);
      });

    }
  }

/*
* This function gets Document. If the healthprofessional is in mode emergency, it show only one document.
* else it show all document of the patient.
*/ 
  getDocument() {
    if(this._patientService.getNotfall()==true){
    this._documentService.getDocument(1).subscribe((documents) => {
      this.documents = documents;
      console.log(documents);
    }, (error) => {
        console.log(error);
    });
    }else{
      this._documentService.getDocuments().subscribe((documents) => {
          this.documents = documents;
          console.log(documents);
        }, (error) => {
            console.log(error);
        });
        }
      console.log(this._http.get(this._url)
      .map((response: Response) => response.toString()));
      return this._http.get(this._url)
      .map((response: Response) => response.toString());
    }

<<<<<<< HEAD
/*
* This function save the rights and navigate back to the listpatient (Dashboard)
*/ 
=======
if(this._userService.getNotfall()==true){
  this._documentService.getDocument(1).subscribe((documents) => {
    this.documents = null;
    this.documents = documents;
    

  
    console.log(documents);
     
   }, (error) => {
      console.log(error);
   });
}else{
    this._documentService.getDocuments().subscribe((documents) => {
        this.documents = documents;
        

        console.log(documents);
         
       }, (error) => {
          console.log(error);
       });

      }
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

  openDocument(){
    
      window.open('www.google.ch',null); 
     
      
      
  

}

>>>>>>> parent of 2042fdf... umbrenennt
saveRight(){
  this._router.navigate(['/dashboard']);
        
}}
