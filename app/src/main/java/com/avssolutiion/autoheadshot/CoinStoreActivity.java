package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityCoinStoreBinding;

public class CoinStoreActivity extends AppCompatActivity implements MaxAdListener {

    ActivityCoinStoreBinding binding;
    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_store);
        binding = ActivityCoinStoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }else {
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }
            }
        });

        binding.ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }else {
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }
            }
        });

        binding.ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }else {
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }
            }
        });

        binding.ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }else {
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }
            }
        });

        binding.ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }else {
                    startActivity(new Intent(CoinStoreActivity.this,CoinsClaimActivity.class));

                }
            }
        });

    }

    @Override
    public void onAdLoaded(MaxAd ad) {

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}