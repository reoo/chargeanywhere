package com.raulomana.chargeanywhere.list;

import android.app.Application;

import com.raulomana.chargeanywhere.db.AppDataBase;
import com.raulomana.chargeanywhere.db.Listing;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ListingsListViewModel extends AndroidViewModel {
    public static final int SORT_BY_ID = 0;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_DATE = 2;

    @NonNull
    private AppDataBase dataBase;
    @Nullable
    private Integer lastId;

    public ListingsListViewModel(@NonNull Application application) {
        super(application);
        dataBase = AppDataBase.getInstance(application);
    }

    @NonNull
    public LiveData<List<Listing>> sortListingsBy(int sortBy) {
        LiveData<List<Listing>> listings;
        if(SORT_BY_ID == sortBy) {
            listings = dataBase.listingDAO().getAllSortById();
        } else if(SORT_BY_NAME == sortBy) {
            listings = dataBase.listingDAO().getAllSortByName();
        } else if(SORT_BY_DATE == sortBy) {
            listings = dataBase.listingDAO().getAllSortByDate();
        } else {
            listings = dataBase.listingDAO().getAll();
        }
        return listings;
    }

    @NonNull
    public LiveData<Listing> getLast() {
        return dataBase.listingDAO().getLast();
    }

    public void setLastId(int id) {
        this.lastId = id;
    }

    @Nullable
    public Integer getLastId() {
        return lastId;
    }

}
