package com.raulomana.chargeanywhere.db;

import android.content.Context;
import android.util.Log;

import com.raulomana.chargeanywhere.utils.DateTimeConverter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Listing.class}, version = 1)
@TypeConverters({DateTimeConverter.class})
public abstract class AppDataBase extends RoomDatabase {
    private static final String LOG_TAG = AppDataBase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "chargeanywhere.db";
    @Nullable
    private static AppDataBase instance;

    @NonNull
    public static AppDataBase getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDataBase.class, AppDataBase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return instance;
    }

    @NonNull
    abstract public ListingDAO listingDAO();

}
