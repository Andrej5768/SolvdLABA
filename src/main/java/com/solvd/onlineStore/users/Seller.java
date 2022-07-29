package com.solvd.onlineStore.users;

import com.solvd.onlineStore.PriceList;
import com.solvd.onlineStore.Storage;
import com.solvd.onlineStore.Wallet;

public class Seller extends User{
    private final ROLE role = ROLE.SELLER;

    private Storage storage;

    private PriceList priceList;

    private Wallet wallet;

}
