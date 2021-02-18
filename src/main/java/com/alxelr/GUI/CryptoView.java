package com.alxelr.GUI;


import com.alxelr.Model.Coin;

public class CryptoView {
    private final String coinName;
    private final String lastPrice;
    private final String valueCoin;
    private final String high24;
    private final String low24;

    public CryptoView(String coinName, String valueCoin, Coin coin) {
        this.coinName = coinName;
        this.lastPrice = coin.getData().getTicker().getLast();
        this.valueCoin = valueCoin;
        this.high24 = coin.getData().getTicker().getHigh();
        this.low24 = coin.getData().getTicker().getLow();
    }

    public String getCoinName() {
        return coinName;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public String getValueCoin() {
        return valueCoin;
    }

    public String getHigh24() {
        return high24;
    }

    public String getLow24() {
        return low24;
    }
}
