import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  val!:string
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  ggg(){
    console.log(this.val)
    if(this.val==="getByDate")
      this.router.navigate(['pull',1])
    else if(this.val==="update")
      this.router.navigate(['update'])
    else if(this.val==="sanction")
      this.router.navigate(['getallloanapplication'])
  }
}
