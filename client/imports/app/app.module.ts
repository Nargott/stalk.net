import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppComponent } from "./app.component";
import { routes } from './app.routes';

import { SidebarComponent } from "./sidebar/sidebar.component";
import { CharactersDataService } from "./characters/characters-data.service";
import { CharactersComponent } from "./characters/characters.component";

@NgModule({
  // Components, Pipes, Directive
  declarations: [
    AppComponent,
    SidebarComponent,
    CharactersComponent
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
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  // Main Component
  bootstrap: [ AppComponent ]
})
export class AppModule {
  constructor() {

  }
}
