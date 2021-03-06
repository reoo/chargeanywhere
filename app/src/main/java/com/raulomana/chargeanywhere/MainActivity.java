package com.raulomana.chargeanywhere;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;
import com.raulomana.chargeanywhere.databinding.ActivityMainBinding;
import com.raulomana.chargeanywhere.db.Listing;
import com.raulomana.chargeanywhere.list.ListingsAdapter;
import com.raulomana.chargeanywhere.list.ListingsListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Observer<List<Listing>> {
    @NonNull
    private ActivityMainBinding binding;
    @NonNull
    private ListingsListViewModel viewModel;
    @Nullable
    private ListingsAdapter adapter;
    @Nullable
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ListingsListViewModel(getApplication());

        binding.mainRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if(R.id.main_checkbox_sort_by_id == checkedId) {
                viewModel.sortListingsBy(ListingsListViewModel.SORT_BY_ID).observe(this, this);
            } else if(R.id.main_checkbox_sort_by_name == checkedId) {
                viewModel.sortListingsBy(ListingsListViewModel.SORT_BY_NAME).observe(this, this);
            } else if(R.id.main_checkbox_sort_by_date == checkedId) {
                viewModel.sortListingsBy(ListingsListViewModel.SORT_BY_DATE).observe(this, this);
            }
        });
        binding.mainRadioGroup.check(R.id.main_checkbox_sort_by_id);

        // init service to populate db each minute
        Intent intent = new Intent(this, StorageService.class);
        PendingIntent alarmIntent = PendingIntent.getService(this, 0, intent, 0);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + StorageService.TRIGGER_AT_IN_MILLIS,
                StorageService.TRIGGER_AT_IN_MILLIS, alarmIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, StorageService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    @Override
    public void onChanged(List<Listing> listings) {
        if(adapter == null) {
            adapter = new ListingsAdapter(listings, null);
            binding.mainItemsList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            binding.mainItemsList.setAdapter(adapter);
        } else {
            adapter.setListings(listings);
            adapter.notifyDataSetChanged();
            binding.mainItemsList.scrollToPosition(listings.size() - 1);
        }


        // show feedback(snackbar) to the user so he will be aware what element was just added
        Observer<Listing> lastItemObserver = new Observer<Listing>() {
            @Override
            public void onChanged(Listing listing) {
                viewModel.getLast().removeObserver(this);
                Integer lastId = viewModel.getLastId();
                if(lastId == null) {
                    viewModel.setLastId(listing.id);
                } else if(lastId != listing.id) {
                    viewModel.setLastId(listing.id);
                    Snackbar.make(binding.mainRadioGroup,
                            getString(R.string.item_added_feedback, listing.name, listing.id), Snackbar.LENGTH_INDEFINITE)
                            .setAction(R.string.cancel, view -> {
                            })
                            .show();
                }
            }
        };
        viewModel.getLast().observe(this, lastItemObserver);
    }
}