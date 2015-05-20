package com.example.training.helloandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    public static final String TAG = MyReceiver.class.getSimpleName();
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.d(TAG,"onReceive ...");
        Log.d(TAG,"displayNotification");
        Intent intentService = new Intent(context,MyIntentService.class);
        intentService.setAction(MyIntentService.ACTION_DOWNLOAD);
        intentService.putExtra(MyIntentService.EXTRA_PARAM1,"http://www.google.fr");
        context.startService(intentService);
    }
}
