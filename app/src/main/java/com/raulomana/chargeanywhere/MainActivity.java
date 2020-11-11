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

import com.raulomana.chargeanywhere.databinding.ActivityMainBinding;
import com.raulomana.chargeanywhere.db.Listing;
import com.raulomana.chargeanywhere.list.ListingsAdapter;
import com.raulomana.chargeanywhere.list.ListingsListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
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
        viewModel.getListings().observe(this, new Observer<List<Listing>>() {
            @Override
            public void onChanged(List<Listing> listings) {
                if(adapter == null) {
                    adapter = new ListingsAdapter(listings, null);
                    binding.mainItemsList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.mainItemsList.setAdapter(adapter);
                } else {
                    adapter.setListings(listings);
                    adapter.notifyDataSetChanged();
                }
            }
        });

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
}