package com.example.penjuris.medicalapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Medicine_Info extends AppCompatActivity {
TextView name,dose,sche,instr;String a,s,d,f;Button b;int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine__info);
        name = (TextView)findViewById(R.id.dname);
        dose = (TextView)findViewById(R.id.ddose);
        sche = (TextView)findViewById(R.id.dsche);
        instr = (TextView)findViewById(R.id.dinstr);
        b = (Button)findViewById(R.id.balarm);
        SharedPreferences sp = getSharedPreferences("Key", Activity.MODE_PRIVATE);
        String a = sp.getString("name", "");
        String s = sp.getString("dose","");
        String d = sp.getString("sche","");
        String f = sp.getString("instr","");
        name.setText("Medicine Name:"+a);
        dose.setText("Dosage:"+s);
        sche.setText("Schedule:"+d);
        instr.setText("Instructions:"+f);
    }
}
