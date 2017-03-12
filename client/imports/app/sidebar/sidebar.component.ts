import { Component, OnInit } from "@angular/core";
import template from "./sidebar.component.html";

@Component({
  selector: "sidebar",
  template,
  styles: [  ]
})
export class SidebarComponent implements OnInit {
  greeting: string;

  constructor() {
    this.greeting = "Hello Menu Component!";
  }

  ngOnInit() {
  }
}
