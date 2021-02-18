package com.alxelr.Database;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseCoin {
    private static final ArrayList<DatabaseCoin> allCoins = new ArrayList<>();
    private final String coinName;
    private final String valueCoin;

    public DatabaseCoin(String coinName, String valueCoin) {
        this.coinName = coinName;
        this.valueCoin = valueCoin;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getValueCoin() {
        return valueCoin;
    }

    public static void add(DatabaseCoin coin)
    {
        allCoins.add(coin);
    }

    public static void remove(String coinName,String valueCoin)
    {
        allCoins.removeIf(o-> o.coinName.equals(coinName) && o.valueCoin.equals(valueCoin));
    }

    public static void load()
    {
        allCoins.clear();
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("cryptos.json"));
            List<DatabaseCoin> coins = Arrays.asList(gson.fromJson(reader, DatabaseCoin[].class));
            allCoins.addAll(coins);
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void save() {
        try {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("cryptos.json"));
            gson.toJson(allCoins, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static ArrayList<DatabaseCoin> getAllCoins()
    {
        return allCoins;
    }
}
