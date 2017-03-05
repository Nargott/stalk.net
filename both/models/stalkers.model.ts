import { SimpleSchema } from 'meteor/aldeed:simple-schema';

export interface StalkersInterface {
    nickname: string;
    legend?: string;
    legendPrivate?: string;
    photo?: string;
    createdAt?: Date;
    updatedAt?: Date;
}

export const StalkersModel = new SimpleSchema({
    nickname: {
        type: String,
        label: "Позывной",
        max: 200
    },
    legend: {
        type: String,
        label: "Легенда",
        optional: true
    },
    legendPrivate: {
        type: String,
        label: "Легенда игромастерская",
        optional: true
    },
    photo: {
        type: String,
        label: "Фотография",
        optional: true
    },
    createdAt: {
        type: Date,
        label: "",
        optional: true
    },
    updatedAt: {
        type: Date,
        label: "",
        optional: true
    }
});