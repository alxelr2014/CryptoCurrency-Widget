package com.alxelr.Model;

import java.util.ArrayList;

public class CoinsData {
    private ArrayList<Coin> coins;

    public CoinsData(ArrayList<Coin> coins) {
        this.coins = coins;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Coin> coins) {
        this.coins = coins;
    }
}
