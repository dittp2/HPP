import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { Router } from '@angular/router';

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

  newUser() {
    let user = new User();
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }
/*
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
  }
/*
    let users = this.users.find(x => x.Id === this.users);
    if (users !== undefined) {
        // You can access Id or Name of the found server object.
        concole.log(server.Name);

    for (let i = 0; i < users.count; i++) {
      if (users[i].name === idSearch) {
        return users[i];
      }
    }
  }
  */
