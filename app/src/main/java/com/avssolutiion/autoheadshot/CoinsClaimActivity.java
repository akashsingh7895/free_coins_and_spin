package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityCoinsClaimBinding;

import java.util.Random;

public class CoinsClaimActivity extends AppCompatActivity implements MaxAdListener {

    ActivityCoinsClaimBinding binding;

    Random random;
    int randomNumber;
    int amount;

    int addCoins2;

    //applovin ads
    public ProgressDialog dialog;

    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins_claim);

        binding = ActivityCoinsClaimBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();



        random = new Random();
        randomNumber = random.nextInt(25);
        binding.coins.setText(String.valueOf("Coins = "+randomNumber));

        //Coins Fetch
        SharedPreferences sharedPreferences1 = getSharedPreferences("MyWallet",MODE_PRIVATE);
        amount = sharedPreferences1.getInt("coins1",0);
        //Coins Fetch


        binding.claimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();

                            SharedPreferences addAMountSp = getSharedPreferences("MyWallet",MODE_PRIVATE);
                            SharedPreferences.Editor addCoin = addAMountSp.edit();
                            addCoins2 = amount+randomNumber;
                            addCoin.putInt("coins1",addCoins2);
                            addCoin.commit();
                            startActivity(new Intent(CoinsClaimActivity.this,SuccessActivity.class));

                        }
                    },4000);
                }else {
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //todo: check if user is already is login
                            dialog.dismiss();

                            SharedPreferences addAMountSp = getSharedPreferences("MyWallet",MODE_PRIVATE);
                            SharedPreferences.Editor addCoin = addAMountSp.edit();
                            addCoins2 = amount+randomNumber;
                            addCoin.putInt("coins1",addCoins2);
                            addCoin.commit();
                            startActivity(new Intent(CoinsClaimActivity.this,SuccessActivity.class));


                        }
                    },4000);
                }

//                if (interstitialAd.isReady()){
//                    interstitialAd.showAd();
//
//
//                }else {
//                    SharedPreferences addAMountSp = getSharedPreferences("MyWallet",MODE_PRIVATE);
//                    SharedPreferences.Editor addCoin = addAMountSp.edit();
//                    addCoins2 = amount+randomNumber;
//                    addCoin.putInt("coins1",addCoins2);
//                    addCoin.commit();
//                    startActivity(new Intent(CoinsClaimActivity.this,SuccessActivity.class));
//                }
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    String shareMessage= "";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id="+getPackageName();
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
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