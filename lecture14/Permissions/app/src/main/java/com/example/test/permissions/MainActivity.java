package com.example.test.permissions;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="logs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           int P= ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);

            switch (P)
            {
                case (PackageManager.PERMISSION_GRANTED):
                    Log.d(TAG, "onCreate: g");
                   break;
                case (PackageManager.PERMISSION_DENIED):
                    Log.d(TAG, "onCreate: d");

                   break;


            }

        }
    }

