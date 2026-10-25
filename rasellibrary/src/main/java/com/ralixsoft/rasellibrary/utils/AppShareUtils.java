
package com.ralixsoft.rasellibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public final class AppShareUtils {

    private AppShareUtils() {
        // Prevent object creation.
    }

    /**
     * Shares the current app's Google Play Store link.
     *
     * @param context Context used to launch the share sheet.
     */
    public static void shareApp(Context context) {

        String packageName = context.getPackageName();

        String appName;

        try {
            ApplicationInfo applicationInfo =
                    context.getApplicationInfo();

            appName = context.getPackageManager()
                    .getApplicationLabel(applicationInfo)
                    .toString();

        } catch (Exception exception) {
            appName = packageName;
        }

        String appUrl =
                "https://play.google.com/store/apps/details?id="
                        + packageName;

        String shareMessage =
                "Check out " + appName
                        + "!\nDownload it here:\n"
                        + appUrl;

        Intent shareIntent =
                new Intent(Intent.ACTION_SEND);

        shareIntent.setType("text/plain");

        shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                shareMessage
        );

        Intent chooserIntent = Intent.createChooser(
                shareIntent,
                "Share app"
        );

        if (!(context instanceof android.app.Activity)) {
            chooserIntent.addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
            );
        }

        context.startActivity(chooserIntent);
    }


}
