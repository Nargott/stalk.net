import {CharactersCollection} from "../../../both/collections/characters.collection";

export class Main {
  start(): void {
    this.initFakeData();
  }

  initFakeData(): void {
    if (CharactersCollection.find({}).cursor.count() === 0) {
      const data: any[] = [{
        nickname: "Dotan"
      }, {
        nickname: "Liran"
      }, {
        nickname: "Uri"
      }];
      data.forEach((obj: any) => {
        CharactersCollection.insert(obj);
      });
    }
  }
}
