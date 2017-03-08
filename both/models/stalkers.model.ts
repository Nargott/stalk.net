import { SimpleSchema } from 'meteor/aldeed:simple-schema';

let schema = {
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
    tags: {
        type: [String],
        label: "Теги",
        optional: true
    },
    experience: {
        type: Number,
        label: "Опыт",
        defaultValue: 0,
        min: 0
    },
    money: {
        type: Number,
        label: "Деньги",
        defaultValue: 0,
        min: 0
    },
    eventsFractions: {
        type: [Object],
        label: "События/фракции",
    },
        "eventsFractions.$.eventId": {
            type: String,
            label: "Событие",
            regEx: SimpleSchema.RegEx.Id
        },
        "eventsFractions.$.fractionId": {
            type: String,
            label: "Группировка",
            regEx: SimpleSchema.RegEx.Id
        },
    inventory: {
        type: [Object],
        optional: true
    },
        "inventory.$.itemId": {
            type: String,
            label: "Предмет",
            regEx: SimpleSchema.RegEx.Id,
            optional: true
        },
        "inventory.$.itemLabel": {
            type: Number,
            label: "Особое название",
            optional: true
        },
        "inventory.$.itemCount": {
            type: Number,
            label: "Количество",
            min: 1
        },
        "inventory.$.itemProps": {
            type: [Object],
            label: "Дополнительные свойства предмета",
            optional: true
        },
    quests: {
        type: [Object],
        label: "Список заданий",
        optional: true
    },
        "quests.$.questId": {
            type: String,
            label: "Задание",
            regEx: SimpleSchema.RegEx.Id
        },
        "quests.$.eventId": {
            type: String,
            label: "Событие",
            regEx: SimpleSchema.RegEx.Id
        },
        "quests.$.questNotes": {
            type: String,
            label: "Особые заметки",
            optional: true
        },
        "quests.$.questProps": {
            type: [Object],
            label: "Дополнительные свойства задания",
            optional: true
        },
        "quests.$.addedAt": {
            type: Date,
            label: "Задание добавлено",
            denyUpdate: true,
            autoValue: function() {
                if ( this.isInsert ) {
                    return new Date;
                }
            }
        },
        "quests.$.completedAt": {
            type: Date,
            label: "Задание завершено",
            defaultValue: null
        },
    createdAt: {
        type: Date,
        label: "Создан",
        denyUpdate: true,
        autoValue: function() {
            if ( this.isInsert ) {
                return new Date;
            }
        }
    },
    updatedAt: {
        type: Date,
        label: "Обновлен",
        optional: true,
        autoValue: function() {
            if ( this.isUpdate ) {
                return new Date;
            }
        }
    }
};

// export interface StalkersInterface {
//     nickname: string;
//     legend?: string;
//     legendPrivate?: string;
//     photo?: string;
//     createdAt?: Date;
//     updatedAt?: Date;
// }

export const StalkersModel = new SimpleSchema(schema);