package com.solvd.onlineStore.users;

import com.solvd.onlineStore.PriceList;
import com.solvd.onlineStore.Storage;

public class Seller extends User{
    private ROLE role = ROLE.SELLER;

    private Storage storage;

    private PriceList priceList;

    private Wallet wallet;



}
