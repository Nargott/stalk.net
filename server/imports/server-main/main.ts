import {StalkersCollection} from "./../../../both/collections/stalkers.collection";
import { StalkersInterface } from "./../../../both/models/stalkers.model";

export class Main {
  start(): void {
    this.initFakeData();
  }

  initFakeData(): void {
    if (StalkersCollection.find({}).cursor.count() === 0) {
      const data: StalkersInterface[] = [{
        nickname: "Dotan",
        createdAt: new Date()
      }, {
        nickname: "Liran",
        createdAt: new Date()
      }, {
        nickname: "Uri",
        createdAt: new Date()
      }];
      data.forEach((obj: StalkersInterface) => {
        StalkersCollection.insert(obj);
      });
    }
  }
}
