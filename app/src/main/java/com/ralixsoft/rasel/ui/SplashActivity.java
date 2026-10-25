package com.ralixsoft.rasel.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ralixsoft.rasel.R;
import com.ralixsoft.rasellibrary.ads.AdConfig;
import com.ralixsoft.rasellibrary.ads.AdManager;
import com.ralixsoft.rasellibrary.logging.LogUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        AdConfig adConfig = new AdConfig();
        adConfig.admobAppId = "ca-app-pub-6008675506822590~4991953285";

        adConfig.bannerNetwork = "admob";
        adConfig.bannerId = "ca-app-pub-6008675506822590/6420764571";

        adConfig.interstitialNetwork = "admob";
        adConfig.interstitialId = "ca-app-pub-6008675506822590/6300978111";

        adConfig.rewardedNetwork = "admob";
        adConfig.rewardedId = "ca-app-pub-6008675506822590/6300978111";

        adConfig.nativeNetwork = "admob";
        adConfig.nativeId = "ca-app-pub-6008675506822590/6300978111";

        adConfig.openAppNetwork = "admob";
        adConfig.openAppId = "ca-app-pub-6008675506822590/6300978111";


        // ✅ Admob Initialize
        AdManager.initialize(SplashActivity.this, adConfig,
                new AdManager.Callback() {
                    @Override
                    public void onSuccess() {
                        LogUtils.d("Admob Initialize Success");

                        runOnUiThread(() -> {
                            // Next Screen
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        });
                    }

                    @Override
                    public void onFailure(String error) {
                        LogUtils.d("Admob Initialize Success");
                    }
                });









    }
    //............................................................... END................................................




}