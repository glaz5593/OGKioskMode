package com.guzon.ogkioskmode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by משה on 18/02/2019.
 */

public class OnPauseReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
