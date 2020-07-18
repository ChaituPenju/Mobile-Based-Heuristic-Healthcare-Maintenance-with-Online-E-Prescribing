package com.example.penjuris.medicalapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class Remainders extends AppCompatActivity {
    Button tpick,dpick,balarm;
    EditText name,dose,sche,instr;
    public DatePicker datepicker;
    public TimePicker timepicker;public String a,b,c,d;
    public static int oyear,omonth,oday,ohour,ominute;
    final static int RQS_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainders);
        tpick = (Button)findViewById(R.id.tpick);
        dpick = (Button)findViewById(R.id.dpick);
        balarm = (Button)findViewById(R.id.balarm);
        name = (EditText)findViewById(R.id.mname);
        dose = (EditText)findViewById(R.id.mdose);
        sche = (EditText)findViewById(R.id.msche);
        instr = (EditText)findViewById(R.id.minstr);

        dpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(datepicker);
            }
        });
        tpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(timepicker);
            }
        });
        balarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                cal.set(oyear,omonth,oday,ohour,ominute,00);
                //cal.set(2017,03,12,10,40,00);
                setAlarm(cal);
                SharedPreferences sp = getSharedPreferences("Key", Activity.MODE_PRIVATE);
                SharedPreferences.Editor edt = sp.edit();
                edt.putString("name", name.getText().toString());
                edt.putString("dose", dose.getText().toString());
                edt.putString("sche",sche.getText().toString());
                edt.putString("instr", instr.getText().toString());
                edt.commit();
                Intent z = new Intent(getApplicationContext(),Medicine_Info.class);
                startActivity(z);
            }
        });
    }
    private void setAlarm(Calendar targetCal){
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
        Toast.makeText(getApplicationContext(),targetCal.getTime()+"!!!!",Toast.LENGTH_SHORT).show();
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new Remainders.TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new Remainders.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ohour = hourOfDay;ominute = minute;
            Toast.makeText(getActivity(),hourOfDay+" : "+minute,Toast.LENGTH_SHORT).show();
        }
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of TimePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month,day);
        }
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            oyear = year;omonth = month;oday=dayOfMonth;
            Toast.makeText(getActivity(),dayOfMonth+"/"+month+"/"+year,Toast.LENGTH_SHORT).show();
        }
    }
}
