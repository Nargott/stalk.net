import { Injectable } from "@angular/core";
import { ObservableCursor } from "meteor-rxjs";
import { StalkersCollection } from "../../../../both/collections/stalkers.collection";
import { StalkersInterface } from "../../../../both/models/stalkers.model";

@Injectable()
export class StalkersDataService {
  private data: ObservableCursor<StalkersInterface>;

  constructor() {
    this.data = StalkersCollection.find({});
  }

  public getData(): ObservableCursor<StalkersInterface> {
    return this.data;
  }
}
