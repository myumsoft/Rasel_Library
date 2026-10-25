package com.ralixsoft.rasellibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ralixsoft.rasellibrary.RaselLibrary;

/**
 * Utility methods for displaying Toast messages.
 *
 * Example:
 * ToastUtils.show(context, "Hello World");
 */
public class ToastUtils {


    // Prevent instantiation.
    private ToastUtils() {
    }


    public static void show(Context context ,@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    public static void showLong(Context context,@NonNull String message) {
       Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


}
