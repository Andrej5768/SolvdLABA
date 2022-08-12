package com.solvd.onlineStore.interfaces;

import com.solvd.onlineStore.service.finance.Wallet;

public interface IMoveMoney {

    public void deposit(long amount);

    public void withdrawal(long amount);
}
