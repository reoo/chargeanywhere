package com.raulomana.chargeanywhere.db;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Listing {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    public String name;
    @Nullable
    public OffsetDateTime date;

    public Listing() {
    }

    public Listing(@NonNull String name, @Nullable String date) {
        this.name = name;
        if(date != null) {
            this.date = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(date, OffsetDateTime::from);
        }
    }
}
