package com.ralixsoft.rasel.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ralixsoft.rasel.R;
import com.ralixsoft.rasellibrary.ads.BannerAdHelper;
import com.ralixsoft.rasellibrary.utils.ToastUtils;

public class MainActivity2 extends AppCompatActivity {

    FrameLayout adContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adContainer = findViewById(R.id.ad_container);

        BannerAdHelper.Show(MainActivity2.this,adContainer);


    }
}