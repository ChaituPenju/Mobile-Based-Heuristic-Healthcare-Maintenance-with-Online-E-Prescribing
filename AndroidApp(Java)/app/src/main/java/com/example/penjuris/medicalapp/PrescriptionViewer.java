package com.example.penjuris.medicalapp;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PrescriptionViewer extends AppCompatActivity {
    String url;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_viewer);
        url = "http://192.168.43.145:8085/doc/PatientLogin.html";
        WebView signin = (WebView) findViewById(R.id.presc);
        signin.getSettings().setLoadsImagesAutomatically(true);
        signin.getSettings().setJavaScriptEnabled(true);
        signin.getSettings().setBuiltInZoomControls(true);
        signin.getSettings().setDisplayZoomControls(true);
        signin.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        signin.loadUrl(url);
    }
}
