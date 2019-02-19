package com.guzon.ogkioskmode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);

        setContentView(R.layout.activity_main);

        if (!Settings.canDrawOverlays(MainActivity.this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" +  getPackageName()));
            startActivityForResult(intent, 123);
        }else{
            startService(new Intent(getApplicationContext(), WindowService.class));
            startService(new Intent(getApplicationContext(), MyService.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning=true;
    }

    @Override
    protected void onPause() {
        isRunning=false;
        super.onPause();
    }

    public void onClick(View view) {
        finish();
    }
}
