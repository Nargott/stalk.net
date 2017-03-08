import { SimpleSchema } from 'meteor/aldeed:simple-schema';

let schema = {
    name: {
        type: String,
        label: "Позывной",
        max: 200
    },
    legend: {
        type: String,
        label: "Легенда, описание группировки",
        optional: true
    },
    icon: {
        type: String,
        label: "Шеврон/Знак группировки",
        optional: true
    },
    money: {
        type: Number,
        label: "Деньги группировки",
        defaultValue: 0,
        min: 0
    },
    eventsMembersCount: {
        type: [Object],
        label: "События/кол-во членов",
    },
        "eventsMembersCount.$.eventId": {
            type: String,
            label: "Событие",
            regEx: SimpleSchema.RegEx.Id
        },
        "eventsMembersCount.$.maxMembers":{
            type: Number,
            label: "Максимальное кол-во членов группировки",
            defaultValue: 0,
            min: 0
        },
        "eventsMembersCount.$.membersCount":{
            type: Number,
            label: "Реальное кол-во членов группировки",
            defaultValue: 0,
            min: 0
        },
    createdAt: {
        type: Date,
        label: "Создана",
        denyUpdate: true,
        autoValue: function() {
            if ( this.isInsert ) {
                return new Date;
            }
        },
    },
    updatedAt: {
        type: Date,
        label: "Обновлена",
        optional: true,
        autoValue: function() {
            if ( this.isUpdate ) {
                return new Date;
            }
        }
    }
};

export const FractionsModel = new SimpleSchema(schema);