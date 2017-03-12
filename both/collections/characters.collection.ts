import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import * as moment from "moment";
import {FractionsCollection} from "fractions.collection";

import { CharactersModel } from '../models/characters.model';

let Characters = new Mongo.Collection('characters');

// fraction() {
//     return Fractions.findOne(this.fractionId);
// }

Characters.helpers({
    // getFraction() {
    //     FractionsCollection.findOne({ _id: this.fractionId });
    // },
    getCreatedAtDate() {
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Characters.attachSchema(CharactersModel);
export const CharactersCollection = new MongoObservable.Collection(Characters);
