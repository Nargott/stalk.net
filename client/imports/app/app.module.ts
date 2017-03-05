import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { StalkersComponent } from "./stalkers/stalkers.component";
import { StalkersDataService } from "./stalkers/stalkers-data.service";

@NgModule({
  // Components, Pipes, Directive
  declarations: [
    AppComponent,
    StalkersComponent
  ],
  // Entry Components
  entryComponents: [
    AppComponent
  ],
  // Providers
  providers: [
    StalkersDataService
  ],
  // Modules
  imports: [
    BrowserModule
  ],
  // Main Component
  bootstrap: [ AppComponent ]
})
export class AppModule {
  constructor() {

  }
}
