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
import { isBoolean } from 'util';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private user: User;
  private documents : Document;
  private healthProfessional: HealthProfessional;
  private _url = 'data.xml';

  private LoginUser;
  private LoginPass;
  private idhealth;
  private notfall;

  private iddoc;
  items = [];

  constructor(private _userService: UserService, private _router: Router,
    private _healthProfessionalService: HealthProfessionalService, private _documentService: DocumentService, private _http: Http) { }

    Login(){
      this._userService.getHealthProfessionalsLogin(this.LoginUser,this.LoginPass).subscribe((healthProfessionals) => {
        console.log(healthProfessionals);
         this.healthProfessional = healthProfessionals;
         if (this.healthProfessional!=null){
              this._userService.setterH(this.healthProfessional);
              if(isBoolean(this.notfall)==true){
                this._router.navigate(['/notfall']);
                this._userService.setNotfall(this.notfall);
              }else{
              console.log(this.healthProfessional);
              this._router.navigate(['/dashboard']);
            }
         }
           
        
      }, (error) => {
        console.log(error);
      });
      
      
   
    }

  ngOnInit() {
    
  }


  processForm() {
  

      }

  getDocument() {

  }


// /Users/pascal/Documents/workspace-sts-3.9.3.RELEASE/HPP/src/main/resources/static/RestClient/src/app/components/user-form/
  readXML() {
    
  }

  openDocument(){
    
      window.open('www.google.ch',null); 
     
      
  

}}
