import { Injectable } from "@angular/core";
import { ObservableCursor } from "meteor-rxjs";
import { CharactersCollection } from "../../../../both/collections/characters.collection";

@Injectable()
export class CharactersDataService {
  private data: ObservableCursor<any>;

  constructor() {
    this.data = CharactersCollection.find({});
  }

  public getData(): ObservableCursor<any> {
    return this.data;
  }
}
