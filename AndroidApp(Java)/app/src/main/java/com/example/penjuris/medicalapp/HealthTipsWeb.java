package com.example.penjuris.medicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HealthTipsWeb extends AppCompatActivity {
WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_web);
        wb = (WebView) findViewById(R.id.webview);
        wb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Retrieve the url that you put into your intent
        String url = getIntent().getStringExtra("URL");
        wb.loadUrl(url);
    }
}
