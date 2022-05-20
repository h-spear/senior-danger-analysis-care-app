package com.example.sda_care.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;

import com.example.sda_care.Activity.DangerIdentificationActivity;
import com.example.sda_care.Activity.SeniorCareListActivity;
import com.example.sda_care.R;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FMS";
    public static final String channelId = "10001";
    private String msg, title;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.e(TAG, "onMessageReceived 호출됨.");
        //title = remoteMessage.getData().get("title");
        title = remoteMessage.getNotification().getTitle();
        Log.e(TAG, ""+title);
        //msg = remoteMessage.getData().get("body");
        msg = remoteMessage.getNotification().getBody();
        Log.e(TAG, "" + msg);
        DangerIdentificationActivity.imageName = remoteMessage.getData().get("message");

        if (remoteMessage.getNotification() != null) {
            if (DangerIdentificationActivity.imageName.length() > 2) {
                sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), DangerIdentificationActivity.class);
            } else {
                sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), SeniorCareListActivity.class);
            }
        }
    }

    @Override
    public void onNewToken(String s) {

    }

    private void sendNotification(String title, String body, Class cls) {
        NotificationManager mManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0, intent,PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this, channelId)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground))
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{1,1000})
                .setContentIntent(contentIntent)
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);

            CharSequence channelName = "Notification Channel";
            String description = "for Oreo";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription(description);

            assert mManager != null;
            mManager.createNotificationChannel(channel);
        } else mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        assert mManager != null;
        mManager.notify(0, mBuilder.build());
    }
}