package com.example.moizahmed.test1.Screens;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.moizahmed.test1.R;
/**
 * Created by umair on 5/9/2016.
 */
public class NotificationsReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();


        Notification noti = new Notification.Builder(arg0)
                .setContentTitle("نوٹیفکیشن")
                .setContentText("")
                .setSmallIcon(R.drawable.icon)
                .build();
        NotificationManager notificationManager = (NotificationManager) arg0.getSystemService(Context.NOTIFICATION_SERVICE);



        noti.defaults |= Notification.DEFAULT_SOUND;
        noti.defaults |= Notification.DEFAULT_VIBRATE;
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);



    }

}
