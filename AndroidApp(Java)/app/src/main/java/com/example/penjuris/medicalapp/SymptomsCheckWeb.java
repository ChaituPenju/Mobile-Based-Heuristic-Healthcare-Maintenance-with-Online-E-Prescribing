package com.example.penjuris.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SymptomsCheckWeb extends AppCompatActivity {
WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_check_web);
        wb = (WebView) findViewById(R.id.webview1);
        wb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Retrieve the url that you put into your intent
        String url = getIntent().getStringExtra("URL");
        wb.loadUrl(url);
    }
}
