package com.example.coronaupdateapplication.viewmodel;

import android.location.Location;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coronaupdateapplication.current.CoronaUpdateResponseModel;
import com.example.coronaupdateapplication.network.CovidNetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaViewModel extends ViewModel {
    private Location location;
    private MutableLiveData<CoronaUpdateResponseModel> responseModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errMsgLiveData = new MutableLiveData<>();
    private String country = "Bangladesh";

    public void setCountry(String country) {
        this.country = country;
    }

    public void loadData(){
        fetchCurrentResponseData();
    }

    private void fetchCurrentResponseData() {
        final String endUrl = String.format("%s?yesterday=true&strict=true&query", country);
        CovidNetworkService.getService().getCurrentData(endUrl).enqueue(new Callback<CoronaUpdateResponseModel>() {
            @Override
            public void onResponse(Call<CoronaUpdateResponseModel> call, Response<CoronaUpdateResponseModel> response) {
                if (response.code() == 200){
                   /* Log.e("weather_test", ""+response.code() );*/
                    responseModelMutableLiveData.postValue(response.body());
                }else if (response.code() == 404){
                    errMsgLiveData.postValue("Country Not Found");
                    /*Log.e("weather_test", ""+response.code() );*/

                }

            }

            @Override
            public void onFailure(Call<CoronaUpdateResponseModel> call, Throwable t) {
                Log.e("weather_test", ""+t );

            }
        });
    }

    public MutableLiveData<CoronaUpdateResponseModel> getResponseModelMutableLiveData() {
        return responseModelMutableLiveData;
    }

    public MutableLiveData<String> getErrMsgLiveData() {
        return errMsgLiveData;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
