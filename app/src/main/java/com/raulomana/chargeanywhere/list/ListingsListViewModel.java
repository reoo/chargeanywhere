package com.raulomana.chargeanywhere.list;

import android.app.Application;

import com.raulomana.chargeanywhere.db.AppDataBase;
import com.raulomana.chargeanywhere.db.Listing;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ListingsListViewModel extends AndroidViewModel {
    public static final int SORT_BY_ID = 0;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_DATE = 2;

    @NonNull
    private AppDataBase dataBase;

    public ListingsListViewModel(@NonNull Application application) {
        super(application);
        dataBase = AppDataBase.getInstance(application);
    }

    @NonNull
    public LiveData<List<Listing>> sortListingsBy(int sortBy) {
        if(SORT_BY_ID == sortBy) {
            return dataBase.listingDAO().getAllSortById();
        } else if(SORT_BY_NAME == sortBy) {
            return dataBase.listingDAO().getAllSortByName();
        } else if(SORT_BY_DATE == sortBy) {
            return dataBase.listingDAO().getAllSortByDate();
        }
        return dataBase.listingDAO().getAll();
    }

}
