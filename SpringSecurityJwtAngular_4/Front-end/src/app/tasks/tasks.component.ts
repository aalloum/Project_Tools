import { Component, OnInit } from '@angular/core';
import { Router }   from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks;
  constructor(public authService:AuthenticationService,private router:Router) { 

  }

  ngOnInit() {
  	this.authService.getTasks()
  	  .subscribe(dat=>{
  	  	 this.tasks=dat;
  	  }, err=>{
  	  	this.authService.logout();
  	  	this.router.navigateByUrl('/login');
  	  })

  }
   onNewTask(){
   	 this.router.navigateByUrl('/new-task');
   }

}
