package com.mycompany.myapplication.activity;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.ReviewItem;
import com.mycompany.myapplication.util.RealPathUtil;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void handleBtnSendBroadcast(View v){
        //방송발생
        Intent intent = new Intent("com.mycompany.myapplication.SelfBroadcast");
        intent.putExtra("title", "MQTT알림");
        intent.putExtra("content", "온도가 비정상임");
        sendBroadcast(intent);
    }

}
