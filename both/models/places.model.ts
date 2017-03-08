import { SimpleSchema } from 'meteor/aldeed:simple-schema';

let schema = {
    title: {
        type: String,
        label: "Название полигона",
        max: 200
    },
    description: {
        type: String,
        label: "Описание полигона",
        optional: true
    },
    mapProperties: {
        type: [Object],
        label: "Карта полигона",
    },
    isActive: {
        type: Boolean,
        label: "Доступен ли полигон",
        defaultValue: true
    },
    createdAt: {
        type: Date,
        label: "Создан",
        denyUpdate: true,
        autoValue: function() {
            if ( this.isInsert ) {
                return new Date;
            }
        },
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

export const PlacesModel = new SimpleSchema(schema);