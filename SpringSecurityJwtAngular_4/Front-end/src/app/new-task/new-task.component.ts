import { Component, OnInit } from '@angular/core';
import { Router }   from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  mode:number=1;
  task:any;
  constructor(private authService:AuthenticationService,private router:Router) { }

  ngOnInit() {
  	if(!this.authService.isAdmin()){
  		this.router.navigateByUrl("/tasks");
  	}
  }

  onSaveTask(task){
  	this.authService.saveTask(task)
  	  .subscribe(resp=>{
  	  	this.task=resp;
  	  	this.mode=2;
  	  }, err=>{
  	  	this.mode=0;
  	    console.log(err);
  	  })
  }

}
