package com.example.test.asnyctask;


import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

public class MyTask extends AsyncTask<String,Void,Boolean> {

    private Context c;

    public MyTask(Context c) {
        this.c = c;
    }

    @Override
    protected Boolean doInBackground(String... params) {

        long startTime= SystemClock.uptimeMillis();
        while((SystemClock.uptimeMillis()-startTime)<10000)
        {

        }


        return true;

    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Toast.makeText(c, "task done", Toast.LENGTH_SHORT).show();

    }
}
