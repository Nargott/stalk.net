import { SimpleSchema } from 'meteor/aldeed:simple-schema';

let schema = {
    title: {
        type: String,
        label: "Название события",
        max: 200
    },
    description: {
        type: String,
        label: "Описание события",
        optional: true
    },
    placeId: {
        type: String,
        label: "Полигон",
        regEx: SimpleSchema.RegEx.Id
    },
    isActive: {
        type: Boolean,
        label: "Активно ли событие",
        defaultValue: true
    },
    dateStart: {
        type: Date,
        label: "Дата старта проведения",
    },
    dateEnd: {
        type: Date,
        label: "Дата окончания проведения",
    },
    costs: {
        type: [Object],
        label: "Информация о взносах"
    },
        "costs.$.cost": {
            type: Number,
            label: "Стоимость",
            decimal: true
        },
        "costs.$.dateStart": {
            type: Date,
            label: "Начальная дата стоимости"
        },
        "costs.$.dateEnd": {
            type: Date,
            label: "Конечная дата стоимости"
        },
    createdAt: {
        type: Date,
        label: "Создано",
        denyUpdate: true,
        autoValue: function() {
            if ( this.isInsert ) {
                return new Date;
            }
        },
    },
    updatedAt: {
        type: Date,
        label: "Обновлено",
        optional: true,
        autoValue: function() {
            if ( this.isUpdate ) {
                return new Date;
            }
        }
    }
};

export const EventsModel = new SimpleSchema(schema);