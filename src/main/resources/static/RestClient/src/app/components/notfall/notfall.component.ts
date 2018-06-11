import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatSelectModule } from '@angular/material/select';



@Component({
  selector: 'app-notfall',
  templateUrl: './notfall.component.html',
  styleUrls: ['./notfall.component.css']
})
export class NotfallComponent implements OnInit {
  private users: User[];
  private healthprofessional: HealthProfessional;
  private idSearch;
  private fnameSearch;
  private lnameSearch;
  private genderSearch;

  constructor(private _userService: UserService, private _router: Router) { }

  ngOnInit() {
    this.healthprofessional = this._userService.getterH();
    console.log(this.healthprofessional);
    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users = users;
      
    }, (error) => {
      console.log(error);
    });
   
  }

  deleteUser(user) {
    this._userService.deleteUser(user.id).subscribe((data) => {
    
    }, (error) => {
      console.log(error);
    });
  }

  updateUser(user) {
    this._userService.setter(user);
    this._router.navigate(['/dossier']);
  }


  searchUser() {
    
    console.log(this.fnameSearch);
    // Suche nach Name und Vorname und oder Geschlecht.
    this._userService.getSearchUsers(this.fnameSearch,this.lnameSearch).subscribe((users) => {
     
      console.log(users);
      this.users = users;

    }, (error) => {
      console.log(error);
    });

    
  //   this._userService.getUser(this.idSearch).subscribe((user) => {
  //     console.log(user);
  //     this.users = [];
  //     this.users[0] = user;
  //   }, (error) => {
  //     console.log(error);
  //   });

  //    this._userService.getUser(this.idSearch).subscribe((user) => {
  //    console.log(user);
  //    this.users = [];
  //    this.users[0] = user;
  //  }, (error) => {
  //    console.log(error);
  //  });
  }
  Logout(){
    this._router.navigate(['/']);
      
  }
  
  // getDocument() {
  //    this.document = this._documentService.getDocument();
  //    console.log(this.document);
  //    return this.document;
  //   }


  
  }


  /*

   newUser() {
      let user = new User();
      this._userService.setter(user);
      this._router.navigate(['/op']);
   }

    searchUser(users, user) {
      let idSearch = this.idSearch.toString();
      console.log(idSearch);
      let fnameSearch = this.fnameSearch.toString();
      console.log(fnameSearch);
      let fnameSearch = this.fnameSearch.toString();
      console.log(fnameSearch);
      console.log(user.fname === fnameSearch);

      this.users.filter(function(user) {
        return user.fname === fnameSearch;
      });

      */

