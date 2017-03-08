import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import * as moment from "moment";

import { FractionsModel } from '../models/fractions.model';

let Fractions = new Mongo.Collection('fractions');

Fractions.helpers({
    getCreatedAtDate() {
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Fractions.attachSchema(FractionsModel);
export const FractionsCollection = new MongoObservable.Collection(Fractions);
