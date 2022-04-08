package com.league.krikett.set;

import static com.league.krikett.CL.uytvna;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.league.krikett.ButtonActivity;
import com.league.krikett.CL;

public class WebSettingCL {

    public static void webSettingCL(CL cl , WebView webViewCL){

        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewCL, true);
        CookieManager.getInstance().setAcceptCookie(true);
        webViewCL.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewCL.getSettings().setSavePassword(true);
        webViewCL.getSettings().setDatabaseEnabled(true);
        webViewCL.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        webViewCL.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_DEFAULT);
        webViewCL.getSettings().setAppCacheEnabled(true);
        webViewCL.getSettings().setLoadsImagesAutomatically(true);
        webViewCL.setSaveEnabled(true);
        webViewCL.getSettings().setMixedContentMode(0);
        webViewCL.setFocusable(true);
        webViewCL.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewCL.getSettings().setJavaScriptEnabled(true);
        webViewCL.getSettings().setAllowContentAccess(true);
        webViewCL.getSettings().setLoadWithOverviewMode(true);
        webViewCL.getSettings().setEnableSmoothTransition(true);
        webViewCL.getSettings().setUseWideViewPort(true);
        webViewCL.getSettings().setSaveFormData(true);
        webViewCL.getSettings().setAllowFileAccess(true);
        webViewCL.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewCL.getSettings().setDomStorageEnabled(true);
        webViewCL.setFocusableInTouchMode(true);
        webViewCL.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(decodeCl("ZXJyb3I9YXBwYWZBczNm")) || url.contains(decodeCl("ZGlzYWJsZWQuaHRtbA=="))){
                    cl.startActivity(new Intent(cl.getApplicationContext(), ButtonActivity.class));
                    cl.finishAffinity();
                    Log.d("weq","bot");
                }
            }
        });
        webViewCL.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (uytvna != null) {
                    uytvna.onReceiveValue(null);
                }
                uytvna = filePath;
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("*/*");
                Intent[] intentArray = new Intent[0];
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE, decodeCl("U2VsZWN0IE9wdGlvbjo="));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                cl.startActivityForResult(chooserIntent, 1);
                return true;
            }
        });
    }

    public static String decodeCl(String yeuw){
        byte[] decoded = android.util.Base64.decode(yeuw, Base64.DEFAULT);
        return new String(decoded);
    }
}
