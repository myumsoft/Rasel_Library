package com.ralixsoft.rasellibrary.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AppRatingUtils {

    private AppRatingUtils() {
        // Prevent object creation.
    }

    /**
     * Opens the current app's Google Play Store listing.
     *
     * @param context Context used to launch Google Play.
     */

    public static void openPlayStore(Context context) {

        String packageName = context.getPackageName();

        Uri playStoreUri = Uri.parse(
                "market://details?id=" + packageName
        );

        Intent playStoreIntent = new Intent(
                Intent.ACTION_VIEW,
                playStoreUri
        );

        playStoreIntent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
        );

        try {
            context.startActivity(playStoreIntent);
        } catch (ActivityNotFoundException exception) {
            Uri webUri = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);

            webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(webIntent);
        }

    }

}
