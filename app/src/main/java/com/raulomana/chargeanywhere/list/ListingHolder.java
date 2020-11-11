package com.raulomana.chargeanywhere.list;

import com.raulomana.chargeanywhere.databinding.ItemListingBinding;
import com.raulomana.chargeanywhere.db.Listing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ListingHolder extends RecyclerView.ViewHolder {
    @NonNull
    private ItemListingBinding binding;
    @Nullable
    private ListingHolderListener listener;

    public interface ListingHolderListener {
        void onListingClick(int position);
    }

    public ListingHolder(@NonNull ItemListingBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindHeader(int type) {
    }

    public void bind(@NonNull Listing listing) {
        if (binding != null) {
            binding.itemListingId.setText("" + listing.id);
            binding.itemListingName.setText(listing.name);
            binding.itemListingDate.setText(listing.date);
        }
    }

}
