package com.example.coronaupdateapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidNetworkService {
    public static CovidNetworkServiceApi getService(){
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://corona.lmao.ninja/v2/countries/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(CovidNetworkServiceApi.class);
    }
}
