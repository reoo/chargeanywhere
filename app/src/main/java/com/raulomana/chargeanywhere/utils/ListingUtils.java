package com.raulomana.chargeanywhere.utils;

import com.raulomana.chargeanywhere.db.Listing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;

public class ListingUtils {

    private static final List<Listing> listings = Arrays.asList(
            new Listing("Tom", "2020-09-08T06:51:56.923"),
            new Listing("Mark", "2020-09-08T06:51:56.923"),
            new Listing("Liza", "2020-09-08T06:51:56.923")
    );

    @NonNull
    public static Listing getRandom() {
        Random random = new Random();
        return listings.get(random.nextInt(listings.size()));
    }

}
