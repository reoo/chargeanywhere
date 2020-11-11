package com.raulomana.chargeanywhere.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raulomana.chargeanywhere.R;
import com.raulomana.chargeanywhere.databinding.ItemListingBinding;
import com.raulomana.chargeanywhere.db.Listing;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ListingsAdapter extends RecyclerView.Adapter<ListingHolder> {

    @NonNull
    private List<Listing> listings;
    @Nullable
    private ListingClickListener listener;

    public interface ListingClickListener {
        void onListingClick(@NonNull Listing listing);
    }

    public ListingsAdapter(@NonNull List<Listing> listings, @Nullable ListingClickListener listener) {
        this.listings = listings;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_listing;
    }

    @NonNull
    @Override
    public ListingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListingBinding binding = ItemListingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListingHolder holder, int position) {
        Listing listing = listings.get(position);
        holder.bind(listing);
    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    private ListingHolder.ListingHolderListener holderListener = new ListingHolder.ListingHolderListener() {
        @Override
        public void onListingClick(int position) {
            if(listener != null) {
            }
        }
    };

    public void setListings(@NonNull List<Listing> listings) {
        this.listings = listings;
    }
}
