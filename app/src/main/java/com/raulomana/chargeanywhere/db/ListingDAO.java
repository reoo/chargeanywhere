package com.raulomana.chargeanywhere.db;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ListingDAO {
    @Query("SELECT * FROM listing")
    LiveData<List<Listing>> getAll();

    @Query("SELECT * FROM listing ORDER BY id")
    LiveData<List<Listing>> getAllSortById();

    @Query("SELECT * FROM listing ORDER BY name")
    LiveData<List<Listing>> getAllSortByName();

    @Query("SELECT * FROM listing ORDER BY date")
    LiveData<List<Listing>> getAllSortByDate();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long save(@NonNull Listing listing);

}
