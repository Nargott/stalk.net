import { Injectable } from "@angular/core";
import { ObservableCursor } from "meteor-rxjs";
import { StalkersCollection } from "../../../../both/collections/stalkers.collection";

@Injectable()
export class StalkersDataService {
  private data: ObservableCursor<any>;

  constructor() {
    this.data = StalkersCollection.find({});
  }

  public getData(): ObservableCursor<any> {
    return this.data;
  }
}
