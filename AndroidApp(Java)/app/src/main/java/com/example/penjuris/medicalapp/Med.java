package com.example.penjuris.medicalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Med extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String url="file:android_asset/AppInfo/index.html";
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);
        WebView main = (WebView) findViewById(R.id.mainview);
        main.getSettings().setLoadsImagesAutomatically(true);
        main.getSettings().setJavaScriptEnabled(true);
        main.getSettings().setBuiltInZoomControls(true);
        main.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        main.loadUrl(url);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.med, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent i = new Intent(getApplicationContext(),Medicine_Info.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prescribe) {
            // Handle the Prescription action
            Intent c = new Intent(Med.this,PrescriptionViewer.class);
            startActivity(c);
        } else if (id == R.id.nav_remainder) {
            Intent d = new Intent(Med.this,Remainders.class);
            startActivity(d);

        } else if (id == R.id.nav_tips) {
            Intent a = new Intent(Med.this,Health_Tips.class);
            startActivity(a);
        } else if (id == R.id.nav_symptoms) {
            final Intent c = new Intent(Med.this,SymptomsCheck.class);
            startActivity(c);

        }else if (id == R.id.nav_music) {
            final Intent b = new Intent(Med.this,Music_Therapy.class);
            startActivity(b);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            String email = "eprescriptionadmein@gmail.com";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Send Email"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        return true;
    }
}
