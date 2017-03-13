import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { CharactersDataService } from "./characters-data.service";
import template from "./characters.component.html";
import style from "./characters.component.scss";

@Component({
  selector: "characters",
  template,
  styles: [ style ]
})
export class CharactersComponent implements OnInit {
  greeting: string;
  data: Observable<any[]>;

  constructor(private charactersDataService: CharactersDataService) {
    this.greeting = "Hello Characters Component!";
  }

  ngOnInit() {
    this.data = this.charactersDataService.getData().zone();
  }
}
