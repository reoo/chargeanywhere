package com.raulomana.chargeanywhere.list;

import android.app.Application;

import com.raulomana.chargeanywhere.db.AppDataBase;
import com.raulomana.chargeanywhere.db.Listing;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ListingsListViewModel extends AndroidViewModel {
    @NonNull
    private AppDataBase dataBase;
    @NonNull
    private LiveData<List<Listing>> listings;

    public ListingsListViewModel(@NonNull Application application) {
        super(application);
        dataBase = AppDataBase.getInstance(application);
        listings = dataBase.listingDAO().getAll();
    }

    @NonNull
    public LiveData<List<Listing>> getListings() {
        return listings;
    }

}
