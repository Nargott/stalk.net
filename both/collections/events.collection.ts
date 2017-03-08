import { MongoObservable } from "meteor-rxjs";
import { Mongo } from 'meteor/mongo';
import * as moment from "moment";

import { EventsModel } from '../models/events.model';

let Events = new Mongo.Collection('events');

Events.helpers({
    getCreatedAtDate() {
        return moment(this.createdAt).format("DD.MM.YYYY HH:mm");
    }
});
Events.attachSchema(EventsModel);
export const EventsCollection = new MongoObservable.Collection(Events);
