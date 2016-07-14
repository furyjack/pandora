package com.example.test.lecture13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        int state=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
        Intent Startservice=new Intent(context,MyService.class);
        context.startService(Startservice);





    }
}
