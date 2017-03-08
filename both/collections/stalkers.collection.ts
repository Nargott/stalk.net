import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import * as moment from "moment";

import { StalkersModel } from '../models/stalkers.model';

let Stalkers = new Mongo.Collection('stalkers');

// fraction() {
//     return Fractions.findOne(this.fractionId);
// }

Stalkers.helpers({
    getCreatedAtDate() {
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Stalkers.attachSchema(StalkersModel);
export const StalkersCollection = new MongoObservable.Collection(Stalkers);