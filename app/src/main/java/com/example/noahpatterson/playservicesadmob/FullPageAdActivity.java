package com.example.noahpatterson.playservicesadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

public class FullPageAdActivity extends AppCompatActivity {
    private Button loadInterstitialButton;
    private Button showInterstitialButton;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_page_ad);

        showInterstitialButton = (Button) findViewById(R.id.showInterstitial);
        showInterstitialButton.setEnabled(false);

        loadInterstitialButton = (Button) findViewById(R.id.loadInterstitial);
    }


    public void loadInterstitial(View view) {
        loadInterstitialButton.setEnabled(false);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.setAdListener(new ToastListener(this) {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                showInterstitialButton.setEnabled(true);
                loadInterstitialButton.setText("Loading Interstitial");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest );
    }

    public void showInterstitial(View view) {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }

        showInterstitialButton.setEnabled(false);
        showInterstitialButton.setText("Interstitial not ready"); 
    }
}
