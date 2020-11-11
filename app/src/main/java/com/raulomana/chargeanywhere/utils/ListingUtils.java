package com.raulomana.chargeanywhere.utils;

import com.raulomana.chargeanywhere.db.Listing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;

public class ListingUtils {

    private static final List<Listing> listings = Arrays.asList(
            new Listing("Gerald R. Ford", "1972-11-08T12:00:00.999+00:00"),
            new Listing("James Carter", "1976-11-08T12:00:00.999+00:00"),
            new Listing("Ronald Reagan", "1980-11-08T12:00:00.999+00:00"),
            new Listing("George H. W. Bush", "1988-11-08T12:00:00.999+00:00"),
            new Listing("William J. Clinton", "1992-11-08T12:00:00.999+00:00"),
            new Listing("George W. Bush", "2000-11-08T12:00:00.999+00:00"),
            new Listing("Barack Obama", "2008-11-04T12:00:00.999-02:00"),
            new Listing("Donald J. Trump", "2016-11-06T12:00:00.999-02:00")
    );

    @NonNull
    public static Listing getRandom() {
        Random random = new Random();
        return listings.get(random.nextInt(listings.size()));
    }

}
