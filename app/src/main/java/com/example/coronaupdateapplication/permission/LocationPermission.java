package com.example.coronaupdateapplication.permission;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;

public class LocationPermission {
    public static boolean isLocationPermissionGranted(Context context){
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED;/*by this method checked, if user give permission or not from before*/

    }

    //method for want permission if permission was not grant from before
    //use this method to know , if user given permission allow or deny "specially it's a callback method"
    public static void requestLocationPermission(ActivityResultLauncher<String> launcher){
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
