import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { Router } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
// import { userInfo } from 'os';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  private users: User[];
  private idSearch;
  private fnameSearch;

  constructor(private _userService: UserService, private _router: Router) { }

  ngOnInit() {
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
    this._router.navigate(['/op']);
  }

  searchUser(){
  
  this._userService.getUser(this.idSearch).subscribe((user) => {
    console.log(user);
    this.users = [];
    this.users[0] = user;
    
  }, (error) => {
    console.log(error);
  });
  
  }

  newUser() {
    let user = new User();
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }
}

