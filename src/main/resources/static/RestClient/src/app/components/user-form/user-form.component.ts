import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../shared-service/patient.service';
import { HealthProfessionalService } from '../../shared-service/healthprofessional.service';
import { Patient } from '../../patient';
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
  private patient: Patient;
  private documents : Document;
  private healthProfessionals: HealthProfessional[];
  private _url = 'data.xml';

  private iddoc;
  items = [];

  constructor(private _patientService: PatientService, private _router: Router,
    private _healthProfessionalService: HealthProfessionalService, private _documentService: DocumentService, private _http: Http) { }

  navigateToHome() {
    this._router.navigate(['/dashboard']);
  }

  ngOnInit() {
    this.patient = this._patientService.getter();
    this._healthProfessionalService.getHealthProfesssionals().subscribe((healthProfessionals) => {
      console.log(healthProfessionals);
      this.healthProfessionals = healthProfessionals;
      this.healthProfessionals.splice(0,1);
    }, (error) => {
    console.log(error);
  });
  this.getDocument();
  }


  processForm() {
    if (this.patient.id === undefined) {
      this._patientService.createUser(this.patient).subscribe((patient) => {
        console.log(patient);
        this._router.navigate(['/dashboard']);
      }, (error) => {
        console.log(error);
      });
    } else {
      this._patientService.updateUser(this.patient).subscribe((patient) => {
        console.log(patient);
        this._router.navigate(['/dashboard']);
      }, (error) => {
        console.log(error);
      });

    }
  }

  getDocument() {

if(this._patientService.getNotfall()==true){
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

saveRight(){
  this._router.navigate(['/dashboard']);
        
}}
