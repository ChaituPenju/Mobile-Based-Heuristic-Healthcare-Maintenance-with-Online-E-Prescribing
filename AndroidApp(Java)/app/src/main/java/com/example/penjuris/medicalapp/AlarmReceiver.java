package com.example.penjuris.medicalapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import android.widget.Toast;


/**
 * Created by Penjuris on 3/12/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private NotificationManager alarmNotificationManager;
    Bundle b;
    @Override
    public void onReceive(Context context, Intent intent) {
        b = new Bundle();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"Alarm:Wake Up");
        ringtone.play();
        Toast.makeText(context,"AlarmReceived",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context.getApplicationContext(), Medicine_Info.class);
        alarmNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(context.getApplicationContext(), 1,
                i  , PendingIntent.FLAG_UPDATE_CURRENT);
        SharedPreferences sp = context.getSharedPreferences("Key", Activity.MODE_PRIVATE);
        String a = sp.getString("name", "");
        String f = sp.getString("instr","");
        NotificationCompat.Builder alarmNotificationBuilder = new NotificationCompat.Builder(
                context).setContentTitle(a).setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(f))
                .setContentText(f);
//.addAction(R.mipmap.ic_launcher,"Goooooo",i);

        alarmNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alarmNotificationBuilder.build());
    }

}

