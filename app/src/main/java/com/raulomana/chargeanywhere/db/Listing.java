package com.raulomana.chargeanywhere.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Listing {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "date")
    public String date;

    public Listing() {
    }

    public Listing(String name, String date) {
        this.name = name;
        this.date = date;
    }
}
