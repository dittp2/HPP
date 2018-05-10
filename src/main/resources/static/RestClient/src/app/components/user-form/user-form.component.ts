import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared-service/user.service';
import { HealthProfessionalService } from '../../shared-service/healthprofessional.service';
import { User } from '../../user';
import { HealthProfessional } from '../../healthProfessional';
import { Router } from '@angular/router';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDividerModule} from '@angular/material/divider';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private user: User;
  private healthProfessional: HealthProfessional;
  private healthProfessionals: HealthProfessional[];


  constructor(private _userService: UserService, private _router: Router, private _healthProfessionalService: HealthProfessionalService) { }

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

}
