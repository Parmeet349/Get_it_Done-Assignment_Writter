package com.askstudios.assignment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Arrays;
import java.util.List;


public class SupportUs extends Activity implements BillingProcessor.IBillingHandler, RewardedVideoAdListener {
    BillingProcessor bp;
    GridLayout mainGrid;
    Dialog myDialog;
    private RewardedVideoAd mRewardedVideoAd;

    public String key =  "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtNbAAAwsVl+CYFYyM6usT2TSk53JVF4HtI3AvpWF+PnDmFmaIxNzZWjX6burlZ7lUma4rL42qz8HAgAy0uYg99Bm+L/jW6+M34pcO94X5S8rMIyIBNjm2E4DYtjpjsheNlqymERRTkCoFQsIKSWWrqkFBVqI9gn0iEvkQY1jJVRbtaYNLn+Xu1W6j8jXzNrZlRcqx8RFlxKSb+kyVtgUbZSI9YnhqYbA/PBhXMOw6vge+sSGWN9vPMfgO1AcuMV2DDCV+UJuqPdok/GQ+FLwm80xWHTmFEZrPQatwuZjIsUD/dE+fNBAMClJ/CEMy8N2+l5ejDXuatuVO9Y6E3L0EQIDAQAB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_us);

        mainGrid = (GridLayout) findViewById(R.id.mainGid);
        setSingleEvent(mainGrid);

        bp = new BillingProcessor(this, key, this);
        bp.initialize();
        myDialog = new Dialog(this);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

/*
        //Test Device
        List<String> testDeviceIds = Arrays.asList("6593DC60835494CA0C76CC220A740429");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
        */

    }


    public void loadRewardedVideoAd(){
        AdRequest request = new AdRequest.Builder().build();
        // mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", request); //Test Ad
        //Ad to be deployed at launch:
        mRewardedVideoAd.loadAd("ca-app-pub-1373723692607134/3731059620", request);
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }


    public void ShowPopup(View v) {
        Button close;
        myDialog.setContentView(R.layout.custom_popup);
        close = (Button) myDialog.findViewById(R.id.close);
        // Google Pay
        Button btnGoogle = (Button) myDialog.findViewById(R.id.google);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Number","parmeet349@okhdfcbank");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(SupportUs.this,"Upi Id Copied: parmeet349@okhdfcbank", Toast.LENGTH_SHORT).show();
                Toast.makeText(SupportUs.this,"Opening Google Pay App", Toast.LENGTH_SHORT).show();
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Phone Pe
        Button btnPhone = (Button) myDialog.findViewById(R.id.phone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Number","parmeet349@okhdfcbank");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(SupportUs.this,"Upi Id Copied: parmeet349@okhdfcbank", Toast.LENGTH_SHORT).show();
                Toast.makeText(SupportUs.this,"Opening Phone Pe App", Toast.LENGTH_SHORT).show();
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Bhim
        Button btnBhim = (Button) myDialog.findViewById(R.id.bhim);
        btnBhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Number","parmeet349@okhdfcbank");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(SupportUs.this,"Upi Id Copied: parmeet349@okhdfcbank", Toast.LENGTH_SHORT).show();
                Toast.makeText(SupportUs.this,"Opening Bhim App", Toast.LENGTH_SHORT).show();
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("in.org.npci.upiapp");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Paytm
        Button btnPaytm = (Button) myDialog.findViewById(R.id.paytm);
        btnPaytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Number","parmeet349@okhdfcbank");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(SupportUs.this,"Upi Id Copied: parmeet349@okhdfcbank", Toast.LENGTH_SHORT).show();
                Toast.makeText(SupportUs.this,"Opening Paytm App", Toast.LENGTH_SHORT).show();
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Close Button
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0;i<mainGrid.getChildCount();i++) {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0){
                        bp.purchase(SupportUs.this,"ten");
                        //Toast.makeText(SupportUs.this,"Rs.10", Toast.LENGTH_SHORT).show();
                    }
                    if(finalI == 1){
                        bp.purchase(SupportUs.this,"twentyfive");
                    }
                    if(finalI == 2){
                        //loadRewardedVideoAd();
                        if (mRewardedVideoAd.isLoaded()) {
                            mRewardedVideoAd.show();
                        }

                        //bp.purchase(SupportUs.this,"twenty_five");

                        //Toast.makeText(SupportUs.this,"Rs.50", Toast.LENGTH_SHORT).show();
                    }
                    if(finalI == 3){
                        //loadRewardedVideoAd();
                        //Toast.makeText(SupportUs.this,"UPI", Toast.LENGTH_SHORT).show();
                    }
                    if(finalI == 4){
                        new AlertDialog.Builder(SupportUs.this)
                                .setTitle("Paytm Number")
                                .setMessage("9022653963")
                                .setNegativeButton("Cancel", null)
                                .setPositiveButton("Copy Number and Open App", new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface arg0, int arg1) {
                                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                        ClipData clip = ClipData.newPlainText("Number","9022653963");
                                        clipboard.setPrimaryClip(clip);
                                        Toast.makeText(SupportUs.this,"Number Copied: 9022653963", Toast.LENGTH_SHORT).show();
                                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                                        if (launchIntent != null) {
                                            startActivity(launchIntent);
                                        } else {
                                            Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }).create().show();
                    }
                    if(finalI == 5){
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://paypal.me/parmeet13"));
                        startActivity(browserIntent);
                        //Toast.makeText(SupportUs.this,"Paypal", Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(SupportUs.this,"Clicked at"+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public void openPaytm(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Number","9022653963");
        clipboard.setPrimaryClip(clip);
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(SupportUs.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        Toast.makeText(SupportUs.this,"Thank You for supporting us", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }


    @Override
    public void onBillingError(int errorCode, Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }else{
            bp.initialize();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
        finish();
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}

