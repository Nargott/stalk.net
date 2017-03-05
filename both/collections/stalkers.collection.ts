import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import { StalkersInterface, StalkersModel } from './../models/stalkers.model';
import * as moment from "moment";

let Stalkers = new Mongo.Collection('stalkers');

// fraction() {
//     return Fractions.findOne(this.fractionId);
// }

Stalkers.helpers({
    createdAtDate() {
        console.log(this.createdAt);
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Stalkers.attachSchema(StalkersModel);
export const StalkersCollection = new MongoObservable.Collection<StalkersInterface>(Stalkers);
