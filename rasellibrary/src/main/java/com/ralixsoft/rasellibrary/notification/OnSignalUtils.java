package com.ralixsoft.rasellibrary.notification;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;

public class OnSignalUtils {

    private OnSignalUtils() {
        // Prevent object creation.
    }

    /**
     * Initializes OneSignal for the current application.
     *
     * Call this method from Application.onCreate().
     *
     * @param appId OneSignal App ID from the dashboard.
     */

    public static void initialize(Context context, String appId){

        if (appId == null || appId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "OneSignal App ID must not be empty."
            );
        }

        OneSignal.initWithContext(context, appId);

    }

    /**
     * Requests notification permission.
     *
     * Call this method from an Activity at an appropriate
     * point in the user experience.
     *
     * @param activity Current foreground Activity.
     */

    public static void requestPermission(Activity activity) {
        OneSignal.getNotifications()
                .requestPermission(false, Continue.none());
    }

}
