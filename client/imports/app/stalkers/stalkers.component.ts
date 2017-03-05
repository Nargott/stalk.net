import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { StalkersDataService } from "./stalkers-data.service";
import { StalkersInterface } from "../../../../both/models/stalkers.model";
import template from "./stalkers.component.html";
import style from "./stalkers.component.scss";

@Component({
  selector: "stalkers",
  template,
  styles: [ style ]
})
export class StalkersComponent implements OnInit {
  greeting: string;
  data: Observable<StalkersInterface[]>;

  constructor(private stalkersDataService: StalkersDataService) {
    this.greeting = "Hello Stalkers Component!";
  }

  ngOnInit() {
    this.data = this.stalkersDataService.getData().zone();
  }
}
