package com.example.test.lecture7;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG="mainactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        FragmentManager mngr=getSupportFragmentManager();
        thirdfragment frag1=thirdfragment.newInstance("hello");
        FragmentTransaction txn=mngr.beginTransaction();
        txn.add(R.id.frag_contain,frag1,null).commit();
        frag1.setOncreateViewListener(new thirdfragment.OnCreateViewListner() {
            @Override
            public void onCreateViewCalled() {
                show_toats1("onCreateViewCalled");
            }
        });

        show_toats1("main");

 

    }

    public void show_toast(String text)
    {
        Log.d(TAG, "show_toast: ");
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

    }
    public void show_toats1(String text)
    {
        Log.d(TAG, "show_toats1: ");
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
