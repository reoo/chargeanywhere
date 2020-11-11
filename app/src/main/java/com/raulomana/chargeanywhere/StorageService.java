package com.raulomana.chargeanywhere;

import android.app.AlarmManager;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.raulomana.chargeanywhere.db.AppDataBase;
import com.raulomana.chargeanywhere.db.Listing;
import com.raulomana.chargeanywhere.utils.ListingUtils;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StorageService extends IntentService {
    public static final String TAG = StorageService.class.getSimpleName();

    public static final long TRIGGER_AT_IN_MILLIS = TimeUnit.MINUTES.toMillis(1);

    @NonNull
    private AppDataBase dataBase;

    public StorageService() {
        super(TAG);
        dataBase = AppDataBase.getInstance(getApplication());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Listing random = ListingUtils.getRandom();
        long id = dataBase.listingDAO().save(random);
        Log.d(TAG, "onHandleIntent() listing stored with id: [" + id + "]");
    }
}
