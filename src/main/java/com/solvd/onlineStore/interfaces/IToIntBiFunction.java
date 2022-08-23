package com.solvd.onlineStore.interfaces;

@FunctionalInterface
public interface IToIntBiFunction<T, U> {

    int applyAsInt(T t, U u);
}