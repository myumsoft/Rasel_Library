package com.ralixsoft.rasellibrary;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Entry point of RaselLibrary.
 *
 * <pre>
 * // Call once in Application.onCreate()
 * RaselLibrary.initialize(this);
 * </pre>
 */
public final class RaselLibrary {

    private static volatile Context appContext;

    private RaselLibrary() {
        // Prevent instantiation.
    }

    public static void initialize(@NonNull Context context) {
        Objects.requireNonNull(context, "context == null");
        appContext = context.getApplicationContext();
    }

    public static boolean isInitialized() {
        return appContext != null;
    }

    @NonNull
    public static Context getContext() {
        Context context = appContext;
        if (context == null) {
            throw new IllegalStateException(
                    "RaselLibrary is not initialized. "
                            + "Call RaselLibrary.initialize(this) in Application.onCreate().");
        }
        return context;
    }


}