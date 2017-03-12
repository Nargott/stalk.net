import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { CharactersComponent } from "./stalkers/characters.component";
import { SidebarComponent } from "./sidebar/sidebar.component";
import { CharactersDataService } from "./stalkers/characters-data.service";

@NgModule({
  // Components, Pipes, Directive
  declarations: [
    AppComponent,
    CharactersComponent,
    SidebarComponent
  ],
  // Entry Components
  entryComponents: [
    AppComponent
  ],
  // Providers
  providers: [
    CharactersDataService
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
