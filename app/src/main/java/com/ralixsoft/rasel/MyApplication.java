package com.ralixsoft.rasel;

import android.app.Application;

import com.ralixsoft.rasellibrary.RaselLibrary;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize RaselLibrary
        RaselLibrary.initialize(this);

    }


}
