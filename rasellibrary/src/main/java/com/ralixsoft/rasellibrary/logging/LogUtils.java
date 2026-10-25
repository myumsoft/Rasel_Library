package com.ralixsoft.rasellibrary.logging;

import android.util.Log;


public class LogUtils {
    private static final String DEFAULT_TAG = "RaselLog";


    private LogUtils() {
        // Prevent object creation.
    }

    /**
     * Logs a debug message.
     */
    public static void d(String message) {
        d(DEFAULT_TAG, message);
    }

    public static void d(String tag, String message) {
        Log.d(tag, message);
    }


    /**
     * Logs an information message.
     */
    public static void i(String message) {
        Log.i(DEFAULT_TAG, message);
    }

    /**
     * Logs a warning message.
     */
    public static void w(String message) {
        Log.w(DEFAULT_TAG, message);
    }


    /**
     * Logs an error message.
     */
    public static void e(String message) {
        Log.e(DEFAULT_TAG, message);
    }

    /**
     * Logs an error message with exception details.
     */
    public static void e(String message, Throwable throwable) {
        Log.e(DEFAULT_TAG, message, throwable);
    }

}
