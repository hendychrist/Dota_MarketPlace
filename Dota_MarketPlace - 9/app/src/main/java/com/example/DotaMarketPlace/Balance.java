package com.example.DotaMarketPlace;

public class Balance {

    public static int ubalance;

    public  Balance(int balance) {
        this.ubalance = balance;
    }

    public static int getUbalance() {
        return ubalance;
    }

    public static void setUbalance(int ubalance) {
        Balance.ubalance = ubalance;
    }
}

