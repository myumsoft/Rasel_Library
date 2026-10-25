package com.ralixsoft.rasel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ralixsoft.rasel.R;
import com.ralixsoft.rasellibrary.ads.BannerAdHelper;
import com.ralixsoft.rasellibrary.ads.MrecAdsHelper;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private FrameLayout adContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the Button by its ID
        button = findViewById(R.id.button);
        adContainer = findViewById(R.id.ad_container);


        button.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity2.class));
        });




         // ✅ Show Toast
         //ToastUtils.show(MainActivity.this,"Hi");

        // ✅ Share App
        //AppShareUtils.shareApp(this);

        // ✅ App Rating
        //AppRatingUtils.openPlayStore(this);

        //✅ Log
        // LogUtils.d("Hello Rasel");

        // ✅  OnSignal Initialize
        // OnSignalUtils.initialize(this, "YOUR_ONESIGNAL_APP_ID");



        // ✅ Library Initialize
        // ✅ Initialize RaselLibrary in Application.onCreate()
        //RaselLibrary.initialize(MainActivity.this);








        // ✅ Banner Ads
        //BannerAdHelper.Show(MainActivity.this,adContainer);

        // ✅ Mrec  Ads
        MrecAdsHelper.Show(MainActivity.this,adContainer);












    }


}