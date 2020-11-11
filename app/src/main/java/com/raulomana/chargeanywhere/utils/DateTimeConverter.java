package com.raulomana.chargeanywhere.utils;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

public class DateTimeConverter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Nullable
    @TypeConverter
    public static OffsetDateTime toOffsetDateTime(@Nullable String value) {
        if(value == null) {
            return null;
        }

        return formatter.parse(value, OffsetDateTime::from);
    }

    @Nullable
    @TypeConverter
    public static String fromOffsetDateTime(@Nullable OffsetDateTime date) {
        if(date == null) {
            return null;
        }
        return date.format(formatter);
    }

}
