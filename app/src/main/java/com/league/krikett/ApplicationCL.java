package com.league.krikett;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.league.krikett.set.ApFbCL;
import com.league.krikett.set.WebSettingCL;
import com.onesignal.OneSignal;

public class ApplicationCL extends Application {

   public static boolean onl;

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ApFbCL.qqweqa = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                }catch (Exception e){

                }
            }
        }).start();

        ApFbCL.skal = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        Log.d("weq",ApFbCL.skal);

        ApFbCL.apfl(this);

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(WebSettingCL.decodeCl("ODQ4MGU4YmQtYjU0ZS00MDMxLWI0ZjMtNWZkODVlYWJjMjBi"));


    }


}
