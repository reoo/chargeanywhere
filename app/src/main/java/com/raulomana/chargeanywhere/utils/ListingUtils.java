package com.raulomana.chargeanywhere.utils;

import com.raulomana.chargeanywhere.db.Listing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;

public class ListingUtils {

    private static final List<Listing> listings = Arrays.asList(
//            new Listing("George Washington", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("John Adams", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Thomas Jefferson", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("James Madison", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("James Monroe", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("John Quincy Adams", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Andrew Jackson", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Martin Van Buren", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("William Henry Harrison", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("John Tyler", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("James K. Polk", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Zachary Taylor", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Millard Fillmore", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Franklin Pierce", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("James Buchanan", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Abraham Lincoln", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Andrew Johnson", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Ulysses S. Grant", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Rutherford B. Hayes", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("James Garfield", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Chester A. Arthur", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Grover Cleveland", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Benjamin Harrison", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Grover Cleveland", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("William McKinley", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Theodore Roosevelt", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("William Howard Taft", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Woodrow Wilson", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Warren G. Harding", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Calvin Coolidge", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Herbert Hoover", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Franklin D. Roosevelt", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Harry S. Truman", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Dwight D. Eisenhower", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("John F. Kennedy", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Lyndon B. Johnson", "2020-09-08T12:00:00.999+00:00"),
//            new Listing("Richard M. Nixon", "2020-09-08T12:00:00.999+00:00"),
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
