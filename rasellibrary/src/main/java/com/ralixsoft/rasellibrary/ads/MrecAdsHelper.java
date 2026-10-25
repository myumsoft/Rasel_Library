package com.ralixsoft.rasellibrary.ads;

import static android.view.View.GONE;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.google.android.libraries.ads.mobile.sdk.banner.AdSize;
import com.google.android.libraries.ads.mobile.sdk.banner.AdView;
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAd;
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAdRequest;
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback;
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;
import com.ralixsoft.rasellibrary.logging.LogUtils;

public class MrecAdsHelper {

    public MrecAdsHelper() {
    }

    public static  void Show(@NonNull Activity activity, @NonNull FrameLayout container){

        AdConfig config = AdManager.getConfig();
        if (config == null || config.bannerId.isEmpty()) {
            container.setVisibility(View.GONE);
            return;
        }

        if (config.bannerId.trim().isEmpty()) {
            LogUtils.d("Banner: ad unit ID is empty");
            LogUtils.d(config.bannerId);
            return;
        }


        switch (config.bannerNetwork) {
            case "admob":
                showAdmob(activity, config.bannerId, container);
                break;

            case "unity":
                showUnity(activity, config.bannerId, container);
                break;

            case "meta":
                showMeta(activity, config.bannerId, container);
                break;

            case "off":
                container.setVisibility(GONE);
                break;


            default:
                LogUtils.d("Banner: unknown network -> " + config.bannerNetwork);
                container.setVisibility(GONE);
        }

    }


    // ❇️ Admob Ads.............
    private static void showAdmob(Activity activity, String adUnitId, FrameLayout adViewContainer){


        LogUtils.d("Call  Admob Banner "+adUnitId);

        AdView adView = new AdView(activity);
        adViewContainer.addView(adView);

        AdSize adSize = AdSize.MEDIUM_RECTANGLE;
        BannerAdRequest adRequest = new BannerAdRequest.Builder(adUnitId, adSize).build();


        adView.loadAd(
                adRequest,
                new AdLoadCallback<BannerAd>() {
                    @Override
                    public void onAdLoaded(@NonNull BannerAd bannerAd) {
                        Log.d(TAG, "Banner ad loaded.");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        Log.d(TAG, "Banner ad failed to load: " + adError);
                    }
                });
    }




    // ❇️ Unity Ads.............
    private static void showUnity(Activity activity, String adUnitId, FrameLayout container){

        LogUtils.d("Call  Unity Banner "+adUnitId);
    }




    // ❇️ Meta Ads.............
    private static void showMeta(Activity activity, String adUnitId, FrameLayout container){

        LogUtils.d("Call  Meta Banner "+adUnitId);
    }

}
