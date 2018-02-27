import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  infos={
    name:'ALLOUM',
    email:'alloum1abderrahim@gmail.com'
  };
  constructor() { }

  ngOnInit() {
  }

}
