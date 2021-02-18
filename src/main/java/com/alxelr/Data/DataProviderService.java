package com.alxelr.Data;

import  com.alxelr.Model.Coin;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.CompletableFuture;

public class DataProviderService {
   public Coin getData(String currency)
   {
       Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.coinex.com/v1/market/").
               addConverterFactory(GsonConverterFactory.create()).build();
        API api = retrofit.create(API.class);
       CompletableFuture<Coin> callback = new CompletableFuture<>();
        api.getCurrencyData(currency).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Coin> call, Response<Coin> response) {
                callback.complete(response.body());
            }

            @Override
            public void onFailure(Call<Coin> call, Throwable throwable) {
                callback.completeExceptionally(throwable);
            }
        });
       return callback.join();
   }
}
