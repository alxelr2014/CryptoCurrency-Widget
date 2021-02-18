package com.alxelr.Data;

import com.alxelr.Model.Coin;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("ticker")
    Call<Coin> getCurrencyData(@Query("market" ) String currency);
}
