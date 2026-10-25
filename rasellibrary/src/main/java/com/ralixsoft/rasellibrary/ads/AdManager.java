package com.ralixsoft.rasellibrary.ads;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.libraries.ads.mobile.sdk.MobileAds;
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationConfig;

public class AdManager {

    private static AdConfig config;   // মডেলটা এখানে থাকবে

    private AdManager() {
        // Prevent instantiation.
    }

    public interface Callback{
        void onSuccess();
        void onFailure(String error);
    }

    public static void initialize(@NonNull Context context,@NonNull AdConfig adConfig,Callback callback) {

        config = adConfig;

        if (adConfig.admobAppId == null || adConfig.admobAppId.trim().isEmpty()) {
            Log.d("AdMobUtils", "App ID must not be empty.");
        }

        new Thread(
                () -> {
                    // Initialize GMA Next-Gen SDK on a background thread.
                    MobileAds.initialize(
                            context,
                            // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
                            new InitializationConfig.Builder(adConfig.admobAppId)
                                    .build(),
                            initializationStatus -> {
                                // Adapter initialization is complete.
                                if (callback != null) {
                                    callback.onSuccess();
                                }
                            });
                    // SDK initialization is complete. If you don't want to wait for bidding adapters to
                    // finish initializing, start loading ads now.
                })
                .start();

    }



    static AdConfig getConfig() {
        return config;
    }


}
