package ca.csualberta.remindme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(title,message);
        notificationHelper.getManager().notify(1,nb.build());

//        String title2 = intent.getStringExtra("title");
//        String message2 = intent.getStringExtra("message");
//        NotificationHelper notificationHelper2 = new NotificationHelper(context);
//        NotificationCompat.Builder nb2 = notificationHelper.getChannelNotification(title,message);
//        notificationHelper.getManager().notify(2,nb2.build());
    }
}
