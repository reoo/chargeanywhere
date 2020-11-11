package com.raulomana.chargeanywhere.list;

import com.raulomana.chargeanywhere.databinding.ItemListingBinding;
import com.raulomana.chargeanywhere.db.Listing;

import org.threeten.bp.format.DateTimeFormatter;

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

    public void bind(@NonNull Listing listing) {
        binding.itemListingId.setText(String.valueOf(listing.id));
        binding.itemListingName.setText(listing.name);
        if(listing.date != null) {
            binding.itemListingDate.setText(listing.date.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        }
    }

}
