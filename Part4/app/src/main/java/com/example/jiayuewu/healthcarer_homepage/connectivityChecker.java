package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.support.v4.content.ContextCompat.getSystemService;

public class connectivityChecker {
    public static Boolean getConnectivity(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}

//connectivityChecker.getConnectivity(context)
