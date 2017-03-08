import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import * as moment from "moment";

import { PlacesModel } from '../models/places.model';

let Places = new Mongo.Collection('places');

// fraction() {
//     return Fractions.findOne(this.fractionId);
// }

Places.helpers({
    getCreatedAtDate() {
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Places.attachSchema(PlacesModel);
export const PlacesCollection = new MongoObservable.Collection(Places);
