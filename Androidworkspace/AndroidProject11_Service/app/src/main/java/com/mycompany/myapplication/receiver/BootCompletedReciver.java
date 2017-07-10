package com.mycompany.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mycompany.myapplication.service.BackgroundService;

public class BootCompletedReciver extends BroadcastReceiver {
    private static final String TAG= "BootCompletedReciver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, BackgroundService.class);

        context.startService(i);

    }
}
