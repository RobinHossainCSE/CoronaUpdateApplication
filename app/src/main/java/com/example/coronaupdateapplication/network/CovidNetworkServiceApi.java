package com.example.coronaupdateapplication.network;

import com.example.coronaupdateapplication.current.CoronaUpdateResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CovidNetworkServiceApi {
    @GET
    Call<CoronaUpdateResponseModel> getCurrentData(@Url String endUrl);
}
