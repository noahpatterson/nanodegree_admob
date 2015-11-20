package com.example.noahpatterson.playservicesadmob;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by noahpatterson on 11/20/15.
 */
public class ToastListener extends AdListener {
    private Context mContext;

    public ToastListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        Toast.makeText(mContext,"ad Closed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorMessage = "Internal Error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorMessage = "invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorMessage = "network error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorMessage = "no fill";
                break;
            default:
                errorMessage = "unknown";
                break;
        }
        Toast.makeText(mContext,String.format("ad failed to load %s", errorMessage), Toast.LENGTH_SHORT).show();
        super.onAdFailedToLoad(errorCode);
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(mContext,"ad left application ", Toast.LENGTH_SHORT).show();
        super.onAdLeftApplication();

    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(mContext,"ad loaded", Toast.LENGTH_SHORT).show();
        super.onAdLoaded();
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
        Toast.makeText(mContext,"ad opened", Toast.LENGTH_SHORT).show();
    }

    private String getErrorReason(int errorCode) {
        return "";
    }
}
