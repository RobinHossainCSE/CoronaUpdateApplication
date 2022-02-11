package com.example.coronaupdateapplication;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coronaupdateapplication.databinding.FragmentCovidUpdateBinding;
import com.example.coronaupdateapplication.permission.LocationPermission;
import com.example.coronaupdateapplication.viewmodel.CoronaViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class CovidUpdateFragment extends Fragment {
    private FragmentCovidUpdateBinding binding;
    private FusedLocationProviderClient providerClient;
    private CoronaViewModel viewModel;
    private double latitude;
    private double longitude;
    private ActivityResultLauncher<String> launcher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted ->{
                if(isGranted){
                    detectUserLocation();
                }else {
                    // show a dialog and explain user why you need
                    //this permission
                }
            });

    @SuppressLint("MissingPermission")
    private void detectUserLocation() {
        providerClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location == null) return;
                    viewModel.setLocation(location);
                    viewModel.loadData();
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    Log.e("WeatherApp", "lat: "+latitude+",lon: "+longitude);
                });
    }


    public CovidUpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.covid_menu, menu);
        final SearchView searchView = (SearchView) menu.
                findItem(R.id.item_search)
                .getActionView();
        searchView.setQueryHint("Search a Country");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.setCountry(query);
                viewModel.loadData();
                searchView.setQuery(null, false);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_myLocation) {
            viewModel.setCountry(getCountry());
            viewModel.loadData();
        }
        return super.onOptionsItemSelected(item);
    }

    private String getCountry(){
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        String countryName = null;
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);;
            if (addresses!=null && addresses.size()>0){
                countryName = addresses.get(0).getCountryName();
//                Toast.makeText(getActivity(), ""+cityName, Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Log.e("testtest", "getCountry: "+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return countryName;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCovidUpdateBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(CoronaViewModel.class);
        viewModel.loadData();
        providerClient = LocationServices.getFusedLocationProviderClient(getActivity());
        if(LocationPermission.isLocationPermissionGranted(getActivity())){
            // if true then call location permission
            detectUserLocation();
        }else {
            //if false then want to  call requestLocationPermission
            LocationPermission.requestLocationPermission(launcher);
        }
        viewModel.getResponseModelMutableLiveData().observe(getViewLifecycleOwner(),
                coronaUpdateResponseModel -> {
                    binding.countryTV.setText(coronaUpdateResponseModel.getCountry());
                    Picasso.get().load(coronaUpdateResponseModel.getCountryInfo().getFlag())
                            .fit()
                            .into(binding.flagIV);
                    binding.updateTimeTV.setText(new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z").format(new Date(coronaUpdateResponseModel.getUpdated())));
                    binding.caseTodayTV.setText(String.valueOf(coronaUpdateResponseModel.getTodayCases()));
                    binding.deathTodayTV.setText(String.valueOf(coronaUpdateResponseModel.getTodayDeaths()));
                    binding.recoverTodayTV.setText(String.valueOf(coronaUpdateResponseModel.getTodayRecovered()));
                    binding.totalcaseTV.setText(String.valueOf(coronaUpdateResponseModel.getCases()));
                    binding.totaldeathTV.setText(String.valueOf(coronaUpdateResponseModel.getDeaths()));
                    binding.totalrecoverTodayTV.setText(String.valueOf(coronaUpdateResponseModel.getRecovered()));

        });
        viewModel.getErrMsgLiveData().observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();

        });
        return binding.getRoot();
    }
}