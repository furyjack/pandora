package com.example.test.lecture14;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    public static final String TAG="ogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  String towrite="hello world!";
        try {


            FileOutputStream stream = openFileOutput("new file", MODE_PRIVATE);
            stream.write(towrite.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } */


        Log.d(TAG, "onCreate: "+ Environment.getExternalStorageDirectory().getAbsolutePath());

        FileInputStream stream=null;
        try {
           stream=openFileInput("new file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(stream));
            StringBuilder total = new StringBuilder();
            String line;

            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
            Log.d(TAG, "onCreate: "+total);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
